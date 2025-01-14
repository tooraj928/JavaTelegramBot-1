/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techselltooraj928.simpleechobot;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

/**
 *
 * @author tooraj
 */

public class MyAmazingBot implements LongPollingSingleThreadUpdateConsumer {  
    private final TelegramClient telegramClient;  

    public MyAmazingBot(String botToken) {  
        // Create the OkHttpTelegramClient with the bot token  
        telegramClient = new OkHttpTelegramClient(botToken); // Keep your original construction  
        // If there's a way to customize the client through configuration options,  
        // you'd need to refer to the documentation for that specific library  
    }  

    @Override  
    public void consume(Update update) {  
        // We check if the update has a message and the message has text  
        if (update.hasMessage() && update.getMessage().hasText()) {  
            // Set variables  
            String message_text = update.getMessage().getText();  
            long chat_id = update.getMessage().getChatId();  

            System.out.print("Sending message: " + message_text + " to chat: " + chat_id);  

            SendMessage message = SendMessage.builder().chatId(chat_id).text(message_text).build();  
            try {  
                telegramClient.execute(message); // Sending our message object to user  
            } catch (TelegramApiException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}  