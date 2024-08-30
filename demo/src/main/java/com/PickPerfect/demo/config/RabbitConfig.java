package com.PickPerfect.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    // Any messages sent to the hk.exchange with the routing key
    // rabbitmq.direct.routing will be routed to the rabbitmq.hk.topic queue!

    public static final String RABBITMQ_HK_TOPIC = "rabbitmq.hk.topic";
    public static final String HK_EXCHANGE = "hk.exchange";
    public static final String RABBITMQ_DIRECT_ROUTING = "rabbitmq.direct.routing";

    // Direct Queue
    @Bean
    public Queue eventQueue() {
        return new Queue(RABBITMQ_HK_TOPIC, true, false, false);
    }

    @Bean
    public DirectExchange eventDirectExchange() {
        return new DirectExchange(HK_EXCHANGE, true, false);
    }

    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(eventQueue()).to(eventDirectExchange()).with(RABBITMQ_DIRECT_ROUTING);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
