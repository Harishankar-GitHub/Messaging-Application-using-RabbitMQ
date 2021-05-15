package com.userA.consumer;

import com.userA.bean.Message;
import com.userA.utils.Utils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import static com.userA.utils.Constants.QUEUE_B;

@Component
public class ConsumeMessage
{
    @RabbitListener(queues = QUEUE_B)
    public void consumeMessageFromB(Message message)
    {
        Utils.logMessage(message);
    }
}
