package com.example.asterix.feature.playwithdb.controller;

import com.example.asterix.feature.playwithdb.model.Message;
import com.example.asterix.feature.playwithdb.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService ms;
    @PostMapping
    public void SaveAMessage(@RequestBody Message message){
        ms.saveMassage(message);


    }

}
