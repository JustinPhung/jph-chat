package com.jph.jphchat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

    @Autowired
    ConversationRepository conversationRepository;


    /**
     *
     * add Message to Convsersation and send it to active members
     *
     * @param chatMessage
     * @return
     */
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message chatMessage) {
        return chatMessage;
    }

    /**
     *
     * add User finds the Overview of the user
     *
     * @param userName
     * @return
     */
    @MessageMapping("/chat.getOverview")
    @SendTo("/topic/public")
    public ChatOverview getOverview(@Payload String userName) {
        //return Overview


        //if user was not found in repository -> add and broadcast new Overviews to online users
        return null;
    }


    @MessageMapping("/chat.joinConversation")
    @SendTo("/topic/public")
    public Conversation joinConversation(@Payload Message chatMessage,
                                   SimpMessageHeaderAccessor headerAccessor) {


        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return null;
    }



    @MessageMapping("/chat.leaveConversation")
    @SendTo("/topic/public")
    public void leaveConversation(@Payload Message chatMessage,
                           SimpMessageHeaderAccessor headerAccessor) {

        //flips the isMemberActiveVariable
    }


}

