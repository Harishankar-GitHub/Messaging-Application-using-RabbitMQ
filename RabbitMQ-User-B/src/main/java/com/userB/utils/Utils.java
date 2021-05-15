package com.userB.utils;

import com.userB.bean.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils
{
    public static void logMessage(Message message)
    {
        log.info(String.format("\n%s:%s,\n%s\n",
                message.getSender(),
                message.getMessage(),
                message.getDateAndTime()));
    }
}
