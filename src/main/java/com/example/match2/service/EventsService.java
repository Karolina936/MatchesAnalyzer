package com.example.match2.service;

import com.example.match2.MapJasonToObjects.MapJasonToObject;
import com.example.match2.model.Event;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EventsService {

    public EventsService(){};
    MapJasonToObject mapper = new MapJasonToObject();
    public List<Event> get10Results() {

        return mapper.mapping().getEvents().stream().limit(10).toList();
    }
}
