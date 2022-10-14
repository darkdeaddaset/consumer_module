package ru.savin.consumer.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.savin.consumer.enums.Types;

@Service
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class MessageListener {

    @RabbitListener(queues = Types.DAILY)
    public void queueDaily(String message){
        System.out.println(String.format("Получено сообщение [%s] из очереди [%s]", message, Types.DAILY));
    }

    @RabbitListener(queues = Types.ALERT)
    public void queueAlert(String message){
        System.out.println(String.format("Получено сообщение [%s] из очереди [%s]", message, Types.ALERT));
    }

    @RabbitListener(queues = Types.ERROR)
    public void queueError(String message){
        System.out.println(String.format("Получено сообщение [%s] из очереди [%s]", message, Types.ERROR));
    }
}
