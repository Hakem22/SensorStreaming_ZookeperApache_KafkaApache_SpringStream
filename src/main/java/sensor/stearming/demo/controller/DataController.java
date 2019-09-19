package sensor.stearming.demo.controller;

import org.springframework.web.bind.annotation.*;
import sensor.stearming.demo.model.Data;

@RestController
public class DataController {

    private final DataService dataService;
    private  final DataListner dataListner;

    public DataController(DataService dataService, DataListner dataListner) {
        this.dataService = dataService;

        this.dataListner = dataListner;
    }

    @GetMapping("/streamdata/post")
    @ResponseBody
    public void streamData(@RequestParam(required = false) String id,@RequestParam("value") String value){
        System.out.println("____________________________________________________value: "+ value);
        Data data=Data.builder()
                .value(value)
                .source(Long.parseLong(id))
                .build();

        System.out.println("Data to be served: "+ data);
        dataService.sendData(data);
    }






}
