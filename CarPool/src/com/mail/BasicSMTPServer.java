package com.mail;

import org.subethamail.smtp.server.SMTPServer;

public class BasicSMTPServer {
        public static void main(String[] args) {
                MyMessageHandlerFactory myFactory = new MyMessageHandlerFactory() ;
                SMTPServer smtpServer = new SMTPServer(myFactory);
                smtpServer.setPort(25000);
                smtpServer.start();
        }
}