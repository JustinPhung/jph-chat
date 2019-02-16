package com.jph.jphchat;


import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.UUID;
import java.util.zip.CRC32;

//getMessages on firstLoad
@Entity
public class Conversation {

    @Id
    private String guid;
    private String member1;
    private boolean isMember1Active;
    private String member2;
    private boolean isMember2Active;
    private Message[] messages;

    public static String generateGUID(String member1, String member2) {
        CRC32 localCRC32Generator = new CRC32();
        localCRC32Generator.update(member1.getBytes());
        Long tempApplicationChecksum = localCRC32Generator.getValue();
        localCRC32Generator.update(member2.getBytes());
        Long tempVersionChecksum = localCRC32Generator.getValue();
        localCRC32Generator.reset();

        Long tempMSBits = tempApplicationChecksum * tempVersionChecksum;
        Long tempLSBits = tempVersionChecksum * tempVersionChecksum;

        StringBuffer tempUUID =
        new StringBuffer(new UUID(tempMSBits, tempLSBits).toString());
        tempUUID.replace(14, 15, "4");
        tempUUID.replace(19, 20,
                convertSecondReservedCharacter(tempUUID.substring(19, 20)));

        return tempUUID.toString();
    }

    private static String convertSecondReservedCharacter(String aString) {
        switch (aString.charAt(0) % 4) {
            case 0: return "8";
            case 1: return "9";
            case 2: return "a";
            case 3: return "b";
            default: return aString;
        }
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMember1() {
        return member1;
    }

    public void setMember1(String member1) {
        this.member1 = member1;
    }

    public String getMember2() {
        return member2;
    }

    public void setMember2(String member2) {
        this.member2 = member2;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    public boolean isMember1Active() {
        return isMember1Active;
    }

    public void setMember1Active(boolean member1Active) {
        isMember1Active = member1Active;
    }

    public boolean isMember2Active() {
        return isMember2Active;
    }

    public void setMember2Active(boolean member2Active) {
        isMember2Active = member2Active;
    }
}

