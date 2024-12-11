package org.siit.projects.phoneApp;

public class Message {
    String phoneNumber;
    String messageContent;

    public Message() {
    }

    public Message(String messageContent) {
        if(messageContent.length() <= 500) {
            this.messageContent = messageContent;
        } else {
            System.out.println("The message exceeds the maximum number of characters.");
        }

    }

    public String getMessageContent() {
        return messageContent;
    }
}
