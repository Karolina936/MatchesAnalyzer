package com.example.match2.MapJasonToObjects;

import com.example.match2.model.Event;
import com.example.match2.model.Events;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.example.match2.model.Event;
import com.example.match2.model.Events;

public class MapJasonToObject {

    public Events mapping() {
        Events events = new Events();

        try{
            FileReader file = new FileReader("C:\\Users\\karol\\IdeaProjects\\Match2\\src\\main\\resources\\BE_data.json");

            ObjectMapper objectMapper = new ObjectMapper();
            events = objectMapper.readValue(file, Events.class);

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        return events;
    }
}
