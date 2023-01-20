package com.example.match2.controler;

import com.example.match2.model.Event;
import com.example.match2.service.EventsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class EventController {

    private final EventsService eventsService;

    public EventController(EventsService events)
    {
        eventsService = events;
    }


    @GetMapping("/")
    public String information(){
        return "Hello";
    }
    @GetMapping("/Result")
    public String information(Model model){
        List<Event> events = eventsService.get10Results();

        model.addAttribute("events", events);

        return "ListOfMatches";
    }

    @GetMapping(value = {"/{number}"})
    public String find(Model model, @PathVariable Integer number) {
        List<Event> events = eventsService.getResults(number);
        model.addAttribute("events", events);
        return "ListUser";
    }

    @GetMapping("/Competitors")
    public String Competitors(Model model) {
        List<String> competitors = eventsService.getTeamsNamesAlphabetically();
        model.addAttribute("competitors", competitors);
        return "ListOfCompetitors";
    }






}
