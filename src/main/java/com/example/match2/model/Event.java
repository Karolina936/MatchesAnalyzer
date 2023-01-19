package com.example.match2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private String sport_event_id;
    private String start_date;
    private String sport_name;
    private String competition_name;
    private String competition_id;
    private String season_name;
    private List<Competitor> competitors;
    private Venue venue;
    private double probability_home_team_winner;
    private double probability_draw;
    private double probability_away_team_winner;

    public String getResult()
    {
        if(probability_home_team_winner > probability_away_team_winner && probability_home_team_winner>probability_draw)
        {
            return "HOME_TEAM_WIN ("+probability_home_team_winner+")";
        }
        else if(probability_away_team_winner > probability_draw)
        {
            return "AWAY_TEAM_WIN ("+probability_away_team_winner+")";
        }

        return "DRAW ("+probability_draw+")";
    }

    private String formatStartDate() {
        String[] date = this.start_date.split("T");
        date[1] = date[1].substring(0, 8);
        return date[0] + " " + date[1];
    }


    public String propablyResult() {
        return "Start date: " + this.formatStartDate() + ",\n"
                + competitors.get(0).toString() + " vs. " + competitors.get(1).toString() + ",\n"
                + (venue != null ? venue.toString() : "No data about venue!") + ",\n"
                + "Highest probable result: " + this.getResult() +"\n";
    }

}
