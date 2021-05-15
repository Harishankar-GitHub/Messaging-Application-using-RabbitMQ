package com.userB.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static com.userB.utils.Constants.*;

@Configuration
public class MessagingConfig
{
    @Bean
    public Queue queue()
    {
        return new Queue(QUEUE_B);
    }

    @Bean
    public TopicExchange exchange()
    {
        return new TopicExchange(EXCHANGE_B);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange)
    {
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY_B);
    }

    @Bean
    public MessageConverter converter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
