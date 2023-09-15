package com.example.asterix.feature.playwithdb.service;

import com.example.asterix.feature.playwithdb.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageService
{
    private MassageReposetory massageRepo;

    public MessageService(MassageReposetory massageRepo)
    {
        this.massageRepo = massageRepo;

        saveThisMessage();
    }

    public Message saveMassage(Message message)
    {
        var result1 = massageRepo.save(message);
        return result1;
    }

    private void saveThisMessage()
    {
        Message m1 = new Message();
        m1.setMessage("call me fox");
        massageRepo.save(m1);
    }
}
