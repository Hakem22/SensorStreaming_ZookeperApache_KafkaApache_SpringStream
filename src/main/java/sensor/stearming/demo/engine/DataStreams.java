package sensor.stearming.demo.engine;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface DataStreams {
    String INPUT= "data-in";
    String OUTPUT= "data-out";

    //method defines the inbound stream to read from Kafka
    @Input(INPUT)
    SubscribableChannel inboundStreams();


    //method defines the outbound stream to write to Kafka
    @Output(OUTPUT)
    MessageChannel outboundStreams();

}
