package it.xpug.birthday_greetings;

public class Greetings {
	Employee employee;
	
	String recipient;
	String body;
	String subject;
	
	String sender;
	
	Greetings(Employee employee){
		this.employee = employee;
		this.recipient = employee.getEmail();
		this.body = "Happy Birthday, dear %NAME%".replace("%NAME%", employee.getFirstName());
		this.subject = "Happy Birthday!";
		this.sender = "sender@here.com";
	}
	
	String getRecipient(){
		return recipient;
	}
	String getBody(){
		return body;
	}
	String getSubject(){
		return subject;
	}
	String getSender(){
		return sender;
	}
	
}
