/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.techselltooraj928.simpleechobot;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

/**
 *
 * @author tooraj
 */
public class Main {  
    public static void main(String[] args) {  
        String botToken = "Paste your telegram token here between these double quotations";  
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {  
            botsApplication.registerBot(botToken, new MyAmazingBot(botToken));  
            System.out.println("MyAmazingBot successfully started!");  
            Thread.currentThread().join();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  