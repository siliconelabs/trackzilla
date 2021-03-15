package com.example.mongo.service;


import com.example.mongo.model.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    void addNewApplicationWTemplate(Application application);

    Application findByIdTemplate(String id);

    void deleteWTemplate(Application application);

    void updateApplicationWTemplate(Application application);

    public List<Application> findAll();

    Optional<Application> findById(String id);

    Application save(Application application);

    void deleteById(String id);
   List< Application> findByName(String name);


}


