package com.jph.jphchat;


public class ChatOverview {


    private String owner;
    private int allUnreadMessages;
    private ChatPartners[] chatPartners;

    public int getAllUnreadMessages() {
        return allUnreadMessages;
    }

    public void setAllUnreadMessages(int allUnreadMessages) {
        this.allUnreadMessages = allUnreadMessages;
    }

    public ChatPartners[] getChatPartners() {
        return chatPartners;
    }

    public void setChatPartners(ChatPartners[] chatPartners) {
        this.chatPartners = chatPartners;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    private class ChatPartners{
        private String name;
        private int unreadMessages;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getUnreadMessages() {
            return unreadMessages;
        }

        public void setUnreadMessages(int unreadMessages) {
            this.unreadMessages = unreadMessages;
        }
    }


}
