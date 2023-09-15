package com.example.asterix.feature.playwithdb.service;

import com.example.asterix.feature.playwithdb.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

//Speichert in DB
public interface MassageReposetory extends MongoRepository<Message, String>
{

}
