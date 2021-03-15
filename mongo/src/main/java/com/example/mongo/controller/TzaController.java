package com.example.mongo.controller;


import com.example.mongo.model.Application;
import com.example.mongo.model.Release;
import com.example.mongo.model.Ticket;
import com.example.mongo.repositories.ApplicationRepository;
import com.example.mongo.repositories.TicketRepository;
import com.example.mongo.service.ApplicationService;
import com.example.mongo.service.ReleaseService;
import com.example.mongo.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/tza")
public class TzaController {


    @Autowired
    private TicketServiceImpl ticketService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ReleaseService releaseService;

    // ************** Methods for Applications *************************

    //Repository Methods

    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public List<Application> getAllApplications() {
        return applicationService.findAll();
    }

    @RequestMapping(value = "/applications/{id}", method = RequestMethod.GET)
    public Optional<Application> getApplicationById(@PathVariable("id") String id) {
        return applicationService.findById(id);
    }

    @RequestMapping(value = "/applications", method = RequestMethod.POST)
    public Application addNewApplication(@RequestBody Application application) {
        return applicationService.save(application);
    }

    @RequestMapping(value = "/applications/{id}", method = RequestMethod.PUT)
    public Application updateApplication(@PathVariable("id") String id, @RequestBody Application application) {
        application.setId(id);
        return applicationService.save(application);
    }

    @RequestMapping(value = "/applications/{id}", method = RequestMethod.DELETE)
    public void deleteApplication(@PathVariable("id") String id) {
        applicationService.deleteById(id);
    }

    @RequestMapping(value = "/applications/name/{name}", method = RequestMethod.GET)
    public List<Application> findByName(@PathVariable("name") String name) {
        return applicationService.findByName(name);
    }

    //MongoTemplate Methods
    @RequestMapping(value = "/applications/template", method = RequestMethod.POST)
    public void addNewApplicationWTemplate(@RequestBody Application application) {
        applicationService.addNewApplicationWTemplate(application);
    }

    @RequestMapping(value = "/applications/template/name/{id}", method = RequestMethod.GET)
    public Application findByIdTemplate(@PathVariable("id") String id) {
        return applicationService.findByIdTemplate(id);
    }

    @RequestMapping(value = "/applications/template", method = RequestMethod.DELETE)
    public void deleteWTemplate(@RequestBody Application application) {
        applicationService.deleteWTemplate(application);
    }

    @RequestMapping(value = "/applications/template", method = RequestMethod.PUT)
    public void updateApplicationWTemplate(@RequestBody Application application) {
        applicationService.updateApplicationWTemplate(application);
    }


    // ************** Methods for Tickets *************************
    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public List<Ticket> getAllTickets() {
        return ticketService.findAll();
    }

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.GET)
    public Optional<Ticket> getTicketById(@PathVariable("id") String id) {
        return ticketService.findById(id);
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public Ticket addNewApplication(@RequestBody Ticket ticket) {
        return ticketService.saveTicket(ticket);
    }

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.PUT)
    public Ticket updateApplication(@PathVariable("id") String id, @RequestBody Ticket ticket) {
        ticket.setId(id);
        return ticketService.saveTicket(ticket);
    }

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable("id") String id) {
        ticketService.deleteTicket(id);
    }

    @RequestMapping(value = "/tickets/status/{status}", method = RequestMethod.GET)
    public List<Ticket> findByStatus(@PathVariable("status") String status) {
        return ticketService.findByStatus(status);
    }

    @RequestMapping(value = "/tickets/count", method = RequestMethod.GET)
    public Long countAllTickets() {
      return ticketService.countAllTickets();
    }
    @RequestMapping(value = "/tickets/appid/{appId}", method = RequestMethod.GET)
    public List<Ticket> findByappId(@PathVariable("appId") String appId) {
        return ticketService.findByappId(appId);
    }
    // ************** Methods for Releases *************************
    @RequestMapping(value = "/releases", method = RequestMethod.GET)
    public List<Release> getAllReleases() {
        return releaseService.findAll();
    }

    @RequestMapping(value = "/releases/{id}", method = RequestMethod.GET)
    public Optional<Release> getReleaseId(@PathVariable("id") String id) {
        return releaseService.findById(id);
    }

    @RequestMapping(value = "/releases", method = RequestMethod.POST)
    public Release addNewRelease(@RequestBody Release release) {
        return releaseService.save(release);
    }

    @RequestMapping(value = "/releases/{id}", method = RequestMethod.PUT)
    public Release updateRelease(@PathVariable("id") String id, @RequestBody Release release) {
        release.setId(id);
        return releaseService.save(release);
    }

    @RequestMapping(value = "/releases/{id}", method = RequestMethod.DELETE)
    public void deleteRelease(@PathVariable("id") String id) {
        releaseService.deleteById(id);
    }

    @RequestMapping(value = "/releases/tickets", method = RequestMethod.PUT)
    public void addNewReleaseWTickets(@RequestBody Release release) {
        releaseService.insert(release);
    }

    @RequestMapping(value = "/releases/status/{status}", method = RequestMethod.GET)
    public List<Release> getReleaseByTicketStatus(@PathVariable("status") String status) {
        return releaseService.getReleaseByTicketStatus(status);
    }

}
