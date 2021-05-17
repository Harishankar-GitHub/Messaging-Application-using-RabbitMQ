package com.userB.utils;

import com.userB.bean.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils
{
    public static void logMessage(Message message)
    {
        System.out.printf("\n%s:%s,\n%s\n%n",
                message.getSender(),
                message.getMessage(),
                message.getDateAndTime());
    }
}
