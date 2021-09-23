class Message:
    @property
    def recipient(self):
        return self.__recipient
    @recipient.setter
    def recipient(self, recipient):
        self.__recipient = recipient

    @property
    def sender(self):
        return self.__sender
    @sender.setter
    def sender(self, sender):
        self.__sender = sender

    @property
    def content(self):
        return self.__content
    @content.setter
    def content(self, content):
        self.__content = content

    @property
    def subject(self):
        return self.__subject
    @subject.setter
    def subject(self, subject):
        self.__subject = subject

"""
Q1. Example
  m = Message()
  m.recipient = 'recipient@email.test'
  m.sender = 'sender@email.test'
  m.content = 'Hello! This is my content!'
  m.subject = 'Test Subject'

  m.is_valid() // id is missing
    => False

Q2. Example
  m = Message()
  m.id = 1
  m.recipient = 'recipient@email.test'
  m.sender = 'sender@email.test'
  m.content = 'Hello! This is my content!'
  m.subject = 'Test Subject'

  input = []
  m.to_json(input)
    => '{ "id": 1, "recipient": "recipient@email.test", "sender": "sender@email.test", "content": "Hello! This is my content!", "subject": "Test Subject" }'

  input = [ "id", "recipient" ]
  m.to_json(input)
    => '{ "id": 1, "recipient": "recipient@email.test" }'

Q3. Example
  m = Message()
  m.id = 10
  m.id
    => 10

  m.from_json('{ "id": 1, "recipient": "recipient@email.test", "sender": "sender@email.test", "content": "Hello! This is my content!", "subject": "Test Subject" }')
  m.id
    => 1
  m.recipient
    => "recipient@email.test"
"""
