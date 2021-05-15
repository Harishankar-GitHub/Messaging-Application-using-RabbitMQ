package com.userA.bean;

import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message
{
    private String sender;
    private String message;
    private String dateAndTime;
}
