package com.example.fortlomtsp.backend.service;

import com.example.fortlomtsp.backend.domain.model.entity.Event;
import com.example.fortlomtsp.backend.domain.persistence.ArtistRepository;
import com.example.fortlomtsp.backend.domain.persistence.EventRepository;
import com.example.fortlomtsp.backend.domain.service.EventService;
import com.example.fortlomtsp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private static final String ENTITY = "Event";
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Event> getAllEvents() {

        return eventRepository.findAll();


    }

    @Override
    public Page<Event> getAllEvents(Pageable pageable) {




        return eventRepository.findAll(pageable);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, eventId));
    }

    @Override
    public Event createEvent(Long artistId, Event request) {

        return artistRepository.findById(artistId)
                .map(artists -> {
                    request.setArtist(artists);
                    Date date = new Date();
                    request.setRegisterdate(date);
                    return eventRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Artist", artistId));
    }

    @Override
    public Event updateEventreleasedate(Long eventId, Date releasedDate) {
        return eventRepository.findById(eventId).map(post->{
            post.setReleasedDate(releasedDate);
            eventRepository.save(post);
            return  post;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, eventId));
    }

    @Override
    public List<Event> getEventsByArtistId(Long artistId) {
        return eventRepository.findByArtistId(artistId);
    }

    @Override
    public ResponseEntity<?> deleteEvent(Long eventId) {
        return eventRepository.findById(eventId).map(event -> {
            eventRepository.delete(event);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, eventId));
    }

    @Override
    public boolean existsById(Long eventId) {
        return eventRepository.existsById(eventId);
    }
}
