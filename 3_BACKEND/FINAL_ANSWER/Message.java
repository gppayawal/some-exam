public class Message {
  private int id;
  private String recipient;
  private String sender;
  private String content;
  private String subject;

  public int getID() { return this.id; }
  public void setID(int id) { this.id = id; }

  public String getRecipient() { return this.recipient; }
  public void setRecipient(String recipient) { this.recipient = recipient; }
  
  public String getSender() { return this.sender; }
  public void setSender(String sender) { this.sender = sender; }

  public String getContent() { return this.content; }
  public void setContent(String content) { this.content = content; }

  public String getSubject() { return this.subject; }
  public void setSubject(String subject) { this.subject = subject; }

  public boolean isValid(){
    boolean validRecipient, validSender, validSubject, validContent;

    //Check if string attributes are not null and not blank
    validRecipient = isNotNullAndNotBlank(this.getRecipient());
    validSender = isNotNullAndNotBlank(this.getSender());
    validSubject = isNotNullAndNotBlank(this.getSubject());
    validContent = isNotNullAndNotBlank(this.getContent());

    if(this.getID() != 0 && validRecipient && validSender && validSubject && validContent) return true;
    return false;
  }

  private boolean isNotNullAndNotBlank(String input){
    if(input != null){ //Check if input is not null, if true - trim whitespaces, then check if trimmed string is empty
      input = input.trim(); 
      if(input.isEmpty()) return false;
    }
    else return false;
    
    return true;
  }

  public String toJson(String[] input){
    //If input is empty, split declared string attributes to populate input array
    String attributes = "id sender recipient subject content";
    if(input.length == 0) input = attributes.split(" ");

    boolean idFlag = false, recipFlag = false, senderFlag = false, subjectFlag = false, contentFlag = false; //our checker if an attribute is part of the input
    int idPos = 0, recipPos = 0, senderPos = 0, subjectPos = 0, contentPos = 0; //for placing commas in the JSON output, if attribute position is not at 0 then we will append a comma

    for(int i = 0; i < input.length; i++){
      if(input[i].equals("id")){
          idFlag = true;
          idPos = i;
      }    
      else if(input[i].equals("recipient")){
          recipFlag = true;
          recipPos = i;
      }    
      else if(input[i].equals("sender")){
          senderFlag = true;
          senderPos = i;
      }    
      else if(input[i].equals("subject")){
          subjectFlag = true;
          subjectPos = i;
      }    
      else if(input[i].equals("content")){
          contentFlag = true;
          contentPos = i;
      }    
    }

    String output = "{ ";
    if(idFlag == true) output = output + "\"id\": " + Integer.toString(this.getID());
    if(recipFlag == true){
        if(recipPos != 0) output = output + ", \"recipient\": " + "\"" + this.getRecipient() + "\"";
        else output = output + "\"recipient\": " + "\"" + this.getRecipient() + "\"";
     }   
    if(senderFlag == true){
        if(senderPos != 0) output = output + ", \"sender\": " + "\"" + this.getSender() + "\"";
        else output = output + "\"sender\": " + "\"" + this.getSender() + "\""; 
    }    
    if(subjectFlag == true){
       if(subjectPos != 0) output = output + ", \"subject\": " + "\"" + this.getSubject() + "\"";
       else output = output + "\"subject\": " + "\"" + this.getSubject() + "\"";
    }   
    if(contentFlag == true){ 
        if(contentPos != 0) output = output + ", \"content\": " + "\"" + this.getContent() + "\"";
        else output = output + "\"content\": " + "\"" + this.getContent() + "\"";
    }    

    output = output + " }";

    return output;
  }

  public void fromJson(String json){
      json = json.substring(2, json.length()-2); //remove the leading { and trailing } enclosing the JSON String
      String[] input;
      input = json.split(", ");

      String[] idAttr = new String[2];
      String[] recipAttr = new String[2];
      String[] senderAttr = new String[2];
      String[] subjAttr = new String[2];
      String[] contAttr = new String[2];

      for(int i = 0; i < input.length; i++){
          if(input[i].contains("\"id\"")){
              idAttr = input[i].split(" ");
              this.setID(Integer.valueOf(idAttr[1]));
          }    
          else if(input[i].contains("\"recipient\"")){
              recipAttr = input[i].split(": ");
               this.setRecipient(recipAttr[1]);
          }    
          else if(input[i].contains("\"sender\"")){
              senderAttr = input[i].split(": "); 
              this.setSender(senderAttr[1]);
          }    
          else if(input[i].contains("\"subject\"")){ 
              subjAttr = input[i].split(": ");
              this.setSubject(subjAttr[1]);
          }    
          else if(input[i].contains("\"content\"")){ 
              contAttr = input[i].split(": ");
              this.setContent(contAttr[1]);
          }       
             
      }
  }

  /*
  Q1. Example:
    Message m = new Message();
    m.setRecipient('recipient@email.test');
    m.setSender('sender@email.test');
    m.setContent('Hello! This is my content!');
    m.setSubject('Test Subject');

    m.isValid(); // id is missing
      => false

  Q2. Example:
    Message m = new Message();
    m.setID(1);
    m.setRecipient('recipient@email.test');
    m.setSender('sender@email.test');
    m.setContent('Hello! This is my content!');
    m.setSubject('Test Subject');

    String[] input = { };
    m.toJson(input);
      => '{ "id": 1, "recipient": "recipient@email.test", "sender": "sender@email.test", "content": "Hello! This is my content!", "subject": "Test Subject" }'

    String[] input = { "id", "recipient" };
    m.toJson(input);
      => '{ "id": 1, "recipient": "recipient@email.test" }'

  Q3. Example:
    Message m = new Message();
    m.setID(10);
    m.getID();
      => 10
    m.fromJson('{ "id": 1, "recipient": "recipient@email.test", "sender": "sender@email.test", "content": "Hello! This is my content!", "subject": "Test Subject" }');
    m.getID();
      => 1
    m.getRecipient();
      => "recipient@email.test"
  */
}

