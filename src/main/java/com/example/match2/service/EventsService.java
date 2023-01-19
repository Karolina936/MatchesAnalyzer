package com.example.match2.service;

import com.example.match2.MapJasonToObjects.MapJasonToObject;
import com.example.match2.model.Event;
import com.example.match2.model.Events;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EventsService {

    public EventsService(){};
    MapJasonToObject mapper = new MapJasonToObject();
    Events events = mapper.mapping();
    public List<Event> get10Results() {

        return events.getEvents().stream().limit(10).toList();
    }

    public List<Event> getResults(int number) {

        int numberOfEvents = events.getEvents().size();
        return mapper.mapping().getEvents().stream().limit((number > numberOfEvents)?  numberOfEvents : number).toList();
    }
}
