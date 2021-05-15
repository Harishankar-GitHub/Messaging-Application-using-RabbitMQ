package com.userB.publisher;

import com.userB.bean.Message;
import com.userB.utils.Utils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import static com.userB.utils.Constants.EXCHANGE_B;
import static com.userB.utils.Constants.ROUTING_KEY_B;

@RestController
public class SendMessageController
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sendMessageToA")
    public String sendMessage(@RequestBody Message message)
    {
        message.setDateAndTime(LocalDateTime.now().toString().substring(0,16));
        rabbitTemplate.convertAndSend(EXCHANGE_B, ROUTING_KEY_B, message);

        Utils.logMessage(message);

        return "Message sent !!";
    }
}
