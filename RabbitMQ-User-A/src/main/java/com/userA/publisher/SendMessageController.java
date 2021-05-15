package com.userA.publisher;

import com.userA.bean.Message;
import com.userA.utils.Utils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import static com.userA.utils.Constants.EXCHANGE_A;
import static com.userA.utils.Constants.ROUTING_KEY_A;

@RestController
public class SendMessageController
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sendMessageToB")
    public String sendMessage(@RequestBody Message message)
    {
        message.setDateAndTime(LocalDateTime.now().toString().substring(0,16));
        rabbitTemplate.convertAndSend(EXCHANGE_A, ROUTING_KEY_A, message);

        Utils.logMessage(message);

        return "Message sent !!";
    }
}
