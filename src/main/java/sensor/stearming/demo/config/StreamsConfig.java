package sensor.stearming.demo.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import sensor.stearming.demo.engine.DataStreams;

@EnableBinding(DataStreams.class)
public class StreamsConfig {
}
