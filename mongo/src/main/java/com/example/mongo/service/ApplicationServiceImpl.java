package com.example.mongo.service;


import com.example.mongo.model.Application;
import com.example.mongo.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public void addNewApplicationWTemplate(Application application) {
        mongoTemplate.insert(application);
    }

    @Override
    public Application findByIdTemplate(String id) {
        return mongoTemplate.findById(id, Application.class);
    }

    @Override
    public void deleteWTemplate(Application application) {
        mongoTemplate.remove(application);
    }

    @Override
    public void updateApplicationWTemplate(Application application) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(application.getName()));
        Update update = new Update();
        update.set("name", "Trainer");
        mongoTemplate.updateFirst(query, update, Application.class);
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public Optional<Application> findById(String id) {

        return applicationRepository.findById(id);
    }

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public void deleteById(String id) {
        applicationRepository.deleteById(id);
    }

    public List<Application> findByName(String name) {
        return applicationRepository.findByName(name);
    }

}
