package com.example.test.rabbit;


import com.example.test.dto.AccountWithOperationDTO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableRabbit
public class MessageListener {

    @SneakyThrows
    @RabbitListener(queues = "${rabbit.notification.queue.name}")
    public void receiveMessage(AccountWithOperationDTO accountWithOperationDTO) {
        Thread.sleep(5000);
        log.info("Account number: {} ", accountWithOperationDTO.getAccountNumber());
        log.info(accountWithOperationDTO.getBalanceOperations().toString(), "{}");
    }
}
