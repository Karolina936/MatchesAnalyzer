package com.example.match2.service;

import com.example.match2.MapJasonToObjects.MapJasonToObject;
import com.example.match2.model.Event;
import com.example.match2.model.Events;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class EventsService {

    public EventsService(){};
    MapJasonToObject mapper = new MapJasonToObject();
    List<Event> events = mapper.mapping().getEvents();



    public List<Event> get10Results() {

        return events.stream().limit(10).toList();
    }

    public List<Event> getResults(int number) {

        int numberOfEvents = events.size();
        return events.stream().limit((number > numberOfEvents)?  numberOfEvents : number).toList();
    }

    public List<String> getTeamsNamesAlphabetically(){

        Set<String> treeSet = new TreeSet<>();
        treeSet.addAll(events.stream().map(events -> events.getCompetitors().get(0).getName()).toList());
        treeSet.addAll(events.stream().map(events -> events.getCompetitors().get(1).getName()).toList());

       return treeSet.stream().toList();
    }
}
