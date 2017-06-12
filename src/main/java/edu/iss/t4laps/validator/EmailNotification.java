package edu.iss.t4laps.validator;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailNotification {
	
	

		
		public static void sendEmail(String emailId,int employeeID)
		{
			String email_id=emailId;
			int empId=employeeID;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("teammyfour@gmail.com","teammyfour4444");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("teammyfour@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email_id));
			message.setSubject("leave application");
			message.setText("Dear Manager ," +
					"\n\n Hi ,Employee with '"+empId+"' applied for leave");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		}
	}


