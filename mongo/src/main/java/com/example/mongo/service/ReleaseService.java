package com.example.mongo.service;



import com.example.mongo.model.Release;

import java.util.List;
import java.util.Optional;

public interface ReleaseService {
    List<Release> getReleaseByTicketStatus(String status);

    List<Release> findAll();

    Optional<Release> findById(String id);

    Release save(Release release);

    void deleteById(String id);

    void insert(Release release);
}
