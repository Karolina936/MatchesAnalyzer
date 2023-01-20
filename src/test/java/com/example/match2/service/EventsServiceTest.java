package com.example.match2.service;

import com.example.match2.MapJasonToObjects.MapJasonToObject;
import com.example.match2.model.Competitor;
import com.example.match2.model.Event;
import com.example.match2.model.Venue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventsServiceTest {

    EventsService eventsService;

    @BeforeEach
    void setUp() {
        eventsService = new EventsService();
    }
    @Test
    void getResultTest() {
        MapJasonToObject mapper = new MapJasonToObject();
        List<Event> events = mapper.mapping().getEvents();
        var expected = List.of(events.get(0),events.get(1));
        var actual = eventsService.getResults(2);

        assertEquals(expected, actual);
    }

    @Test
    void getResultTest2() {
        List<Competitor> competitors = new ArrayList<>();
        competitors.add(new Competitor("sr:competitor:37863", "SS Folgore Falciano Calcio",
                "San Marino", "SMR", "FFC", "home", "male"));
        competitors.add(new Competitor("sr:competitor:277829", "FC Prishtina", "Kosovo",
                "KOS", "PRI", "away", "male"));

        var expected = List.of(new Event("sr:sport_event:27636100", "2021-06-22T18:00:00+00:00",
                "Soccer",
                "UEFA Champions League",
                "sr:competition:7",
                "UEFA Champions League 21/22",
                competitors,
                new Venue("sr:venue:8329", "Elbasan Arena", 12500, "Elbasan",
                        "Albania", "41.115875,20.091992", "ALB"),
                2.5,
                88.1,
                9.4));

        var actual = eventsService.getResults(1);

        assertEquals(expected, actual);
    }

    @Test
    void getTeamsNamesAlphabeticallyTest()
    {
        var expected = List.of( "AC Omonia Nicosia","AS Monaco", "Benfica Lisbon", "Bodoe/Glimt", "CS Fola Esch",
                "Celtic Glasgow", "Connah`s Quay Nomads FC", "FC Alashkert Yerevan", "FC CFR 1907 Cluj", "FC Dinamo Tbilisi",
                "FC Kairat Almaty", "FC Midtjylland", "FC Prishtina", "FC Shakhtar Donetsk", "FC Shakhter Soligorsk",
                "FC Sheriff Tiraspol", "FK Borac Banja Luka", "FK Buducnost", "FK Crvena Zvezda Belgrade", "FK Spartak Moscow",
                "Ferencvarosi Budapest", "Flora Tallinn", "GNK Dinamo Zagreb", "Galatasaray Istanbul", "Glasgow Rangers",
                "HB Torshavn", "HJK Helsinki","Hibernians FC Paola", "Inter Club de Escaldes", "KF Teuta", "KRC Genk",
                "Legia Warszawa", "Lincoln Red Imps", "Linfield FC", "Maccabi Haifa FC", "Malmo FF", "Mura Murska Sobota",
                "Neftchi Baku PFC", "Olympiacos Piraeus", "PFC Ludogorets 1945 Razgrad", "PSV Eindhoven", "Riga FC",
                "SK Rapid Wien", "SS Folgore Falciano Calcio", "Shamrock Rovers", "Shkendija Tetovo", "Slavia Prague",
                "Slovan Bratislava", "Sparta Prague", "Valur Reykjavik", "Vilnius FK Zalgiris", "Young Boys Bern");

        var actual = eventsService.getTeamsNamesAlphabetically();

        assertEquals(expected, actual);

    }



}