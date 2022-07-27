package cn.chen.springcloud.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerService {

    @Value("${server.port}")
    private String port;


    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message){
        System.out.println(port + "收到消息：\t" + message.getPayload());
    }
}
