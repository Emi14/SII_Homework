package org.siit.homework.week4.first;

public class Message {

    private int place;
    private String messageContent;

    public Message(int place, String messageContent) {
        this.place = place;
        this.messageContent = messageContent;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
