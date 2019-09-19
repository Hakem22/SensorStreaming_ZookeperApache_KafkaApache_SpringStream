package sensor.stearming.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import sensor.stearming.demo.engine.DataStreams;
import sensor.stearming.demo.model.Data;

@Service
@Slf4j
public class DataListner {

    @Autowired
    SimpMessagingTemplate template;

    @StreamListener(DataStreams.INPUT)
    public void handelStreamingData(@Payload Data data){
        System.out.print("_________________Recieved Data Streaming: {}"+data);
        log.info("Recieved Data Streaming: {}",data);
        template.convertAndSend("/data/value", data);

    }

}
