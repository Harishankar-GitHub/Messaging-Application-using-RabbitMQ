package com.userB.consumer;

import com.userB.bean.Message;
import com.userB.utils.Utils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import static com.userB.utils.Constants.QUEUE_A;

@Component
public class ConsumeMessage
{
    @RabbitListener(queues = QUEUE_A)
    public void consumeMessageFromA(Message message)
    {
        Utils.logMessage(message);
    }
}
