package com.example.mongo.service;

import com.example.mongo.model.Ticket;
import com.example.mongo.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TicketServiceImpl {
    @Autowired
    TicketRepository ticketRepository;

   public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

  public  Optional<Ticket> findById(String id) {
        return ticketRepository.findById(id);
    }

    public Ticket saveTicket( Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(String id) {
        ticketRepository.deleteById(id);
    }

    public List<Ticket> findByStatus( String status)
    {
        return ticketRepository.findByStatus(status);
    }

    public Long countAllTickets() {
        Stream<Ticket> stream = ticketRepository.findAllByCustomQueryAndStream("Open");
        Long count = stream.count();
        stream.close();
        return count;
    }

    public List<Ticket> findByappId( String appId) {
        return ticketRepository.findByAppId(appId);
    }
}
