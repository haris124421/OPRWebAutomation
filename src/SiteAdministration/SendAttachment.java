package SiteAdministration;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
  
class SendAttachment{  
	
	
	
	
	
	public void main(String[] args){  
  
	 String to = "muhammad.haris@amigo-software.com";

	// Add sender
	 String from = "qa-opr@amigo-software.com";
	 final String username = "qa-opr@amigo-software.com";//your Gmail username 
	 final String password = "OPRqa@2017";//your Gmail password

	String host = "auth.smtp.1and1.co.uk";

	Properties props = new Properties();
	 props.put("mail.smtp.auth", "true");
	 //props.put("mail.smtp.starttls.enable", "true"); 
	 props.put("mail.smtp.host", host);
	 props.put("mail.smtp.port", "587");

	// Get the Session object
	 Session session = Session.getInstance(props,
	 new javax.mail.Authenticator() {
	 protected PasswordAuthentication getPasswordAuthentication() {
	 return new PasswordAuthentication(username, password);
	 }
	 });

	try {
	 // Create a default MimeMessage object
	 Message message = new MimeMessage(session);
	 
	 message.setFrom(new InternetAddress(from));
	 
	 message.setRecipients(Message.RecipientType.TO,
	 InternetAddress.parse(to));
	 
	 // Set Subject
	 message.setSubject("Web Test Automation Result");
	 
	 
	 
	 // Put the content of your message
	

	// Create another object to add another content
				MimeBodyPart messageBodyPart2 = new MimeBodyPart();
				MimeBodyPart messageBodyPart1= new MimeBodyPart();
				
				String filename = "C:\\Selenium\\Book1.xlsx";
	 
				// Create data source and pass the filename
				DataSource source = new FileDataSource(filename);
	 
				// set the handler
				messageBodyPart2.setDataHandler(new DataHandler(source));
	 
				// set the file
				messageBodyPart2.setFileName(filename);
	 
				// Create object of MimeMultipart class
				Multipart multipart = new MimeMultipart();
	 
				// add body part 1
				messageBodyPart1.setText("Hi \n PFA \n\n Regards, \n QA Team");
	 
				// add body part 2
				multipart.addBodyPart(messageBodyPart2);
				multipart.addBodyPart(messageBodyPart1);
				// set the content
				message.setContent(multipart);
	// Send message
	 Transport.send(message);

	System.out.println("Sent message successfully....");

	} catch (MessagingException e) {
	 throw new RuntimeException(e);
	 }
	 }
}  