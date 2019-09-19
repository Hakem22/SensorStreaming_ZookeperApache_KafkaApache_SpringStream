package sensor.stearming.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Bean;


@Getter @Setter @ToString @Builder
public class Data {
    //Represent the message object sent by sensor

    //indicate which sensor
    private long source;
    private String value;
}
