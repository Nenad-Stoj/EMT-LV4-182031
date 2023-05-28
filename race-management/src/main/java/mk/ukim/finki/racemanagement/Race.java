package mk.ukim.finki.racemanagement;

import mk.ukim.finki.emt.runnerdata.Runner;
import mk.ukim.finki.emt.sharedkernel.AbstractValueObject;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "races")
public class Race extends AbstractValueObject {
    @Column(nullable = false)
    private String name;

    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Runner> runners = new ArrayList<>();

    public Race() {
    }

    public Race(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }



    public void addRunner(Runner runner) {
        runners.add(runner);
        runner.setRace(this);
    }

    public void removeRunner(Runner runner) {
        runners.remove(runner);
        runner.setRace(null);
    }

    // Other methods, getters, and setters
}
