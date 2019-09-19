package sensor.stearming.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import sensor.stearming.demo.engine.DataStreams;
import sensor.stearming.demo.model.Data;

@Service
@Slf4j
public class DataService {

    private final DataStreams dataStreams;

    public DataService(DataStreams dataStreams) {
        this.dataStreams = dataStreams;
    }

    public void sendData(final Data data){

        System.out.println("________________________________Streaming Data Sent {}"+ data);
        log.info("Streaming Data sent {}",data);

        //method we use the injected DataStream object to send a message represented by the Data object.
        MessageChannel messageChannel=dataStreams.outboundStreams();
        messageChannel.send(MessageBuilder.withPayload(data)
                                            .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                                            .build());
    }
}
