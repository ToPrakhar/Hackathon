package com.infy.servlets;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMailServlet extends HttpServlet{
	
	private boolean isSendtingToEmail;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String emailId = req.getParameter("email");
		 String mobile= req.getParameter("mobile");
		 mobile="1"+mobile+"@tmomail.net";
		 isSendtingToEmail=true;
			sendEmail(emailId);
		isSendtingToEmail=false;
		sendEmail(mobile);


	      
		 
	}
	
	public void sendEmail(String reciepient)
	{
		String[] to= new String[]{reciepient};
		try{
		String host = "smtp.gmail.com";
	    String from = "carpoolinfy@gmail.com";
	    String pass = "mar@2015";
	    Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true"); // added this line
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", from);
	    props.put("mail.smtp.password", pass);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");
	    Session session = Session.getDefaultInstance(props, null);
	    MimeMessage message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(from));

	    InternetAddress[] toAddress = new InternetAddress[to.length];

	    // To get the array of addresses
	    for( int i=0; i < to.length; i++ ) { // changed from a while loop
	        toAddress[i] = new InternetAddress(to[i]);
	    }
	    System.out.println(Message.RecipientType.TO);

	    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
	        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	    }
	   
	    if(isSendtingToEmail)
	    {
	    message.setSubject("Infosys Email Car Pool Message");
	    message.setText("Your Temporary password is 123456. Please use it along with the password sent on you registered mobile number to access the application");
	    }
	    else{
	    	 message.setSubject("Infosys Mobile Car Pool Message");
	    	message.setText("your one time password to login is 1234.This password will expire in 15 min");	
	    }
	    
	    Transport transport = session.getTransport("smtp");
	    transport.connect(host, from, pass);
	    transport.sendMessage(message, message.getAllRecipients());
	    transport.close();
         System.out.println("Sent message successfully....");
		
		 }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
		 }
	

}
