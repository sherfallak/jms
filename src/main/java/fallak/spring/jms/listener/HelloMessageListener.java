package fallak.spring.jms.listener;

import fallak.spring.jms.config.JmsConfig;
import fallak.spring.jms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.my_Queue)
    public void messageListener(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders messageHeaders, Message message){
    System.out.println("I got a message");
    System.out.println(helloWorldMessage);

    //throw new RuntimeException("helloMessageListenerException");
    }
}
