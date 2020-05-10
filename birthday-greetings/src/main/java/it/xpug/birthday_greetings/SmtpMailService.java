package it.xpug.birthday_greetings;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmtpMailService implements IMessageService{
	String smtpHost;
	int smtpPort;
	
	SmtpMailService(String smtpHost, int smtpPort){
		this.smtpHost = smtpHost;
		this.smtpPort = smtpPort;
	}

	public void send(Greetings greetings) throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", "" + smtpPort);
		Session session = Session.getInstance(props, null);

		// Construct the message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(greetings.sender));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(greetings.recipient));
		msg.setSubject(greetings.subject);
		msg.setText(greetings.body);

		// Send the message
		Transport.send(msg);
		
	}


	


	

}
