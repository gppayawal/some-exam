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

