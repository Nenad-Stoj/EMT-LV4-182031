package mk.ukim.finki.emt.runnerdata;

import jakarta.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import mk.ukim.finki.emt.sharedkernel.AbstractValueObject;
import mk.ukim.finki.emt.sharedkernel.RaceTime;
import mk.ukim.finki.racemanagement.Race;


@Entity
@Table(name = "runners")
public class Runner extends AbstractValueObject {
    private String name;
    private int age;
    private RaceTime raceTime;
    private Race race;

    public Runner() {

    }

    public Runner(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setRace(Race r)
    {
        this.race = r;
    }
    public RaceTime getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(RaceTime raceTime) {
        this.raceTime = raceTime;
    }

    public void startRace() {
        if (raceTime != null) {
            raceTime.getStartTime();
        }
    }

    public void finishRace() {
        if (raceTime != null) {
            raceTime.getFinishTime();
        }
    }

    public String getElapsedTime() {
        if (raceTime != null) {
            return raceTime.calculateElapsedTime().toString();
        }
        return "N/A";
    }

    // Other methods, getters, and setters
}