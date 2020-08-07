package fallak.spring.jms.sender;

import fallak.spring.jms.config.JmsConfig;
import fallak.spring.jms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class MsgSender {
    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        System.out.println("I'm sending message");
        HelloWorldMessage message=HelloWorldMessage
                .builder()
                .uuid(UUID.randomUUID())
                .message("Hello world")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.my_Queue, message);
        System.out.println("message sent");
    }
}
