package mk.ukim.finki.emt.sharedkernel;

import mk.ukim.finki.emt.sharedkernel.AbstractValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class RaceTime extends AbstractValueObject implements Serializable {
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "finish_time")
    private LocalDateTime finishTime;

    public RaceTime() {
    }

    public RaceTime(LocalDateTime startTime, LocalDateTime finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }


    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public Duration calculateElapsedTime() {
        return Duration.between(startTime, finishTime);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RaceTime)) return false;
        RaceTime raceTime = (RaceTime) o;
        return Objects.equals(startTime, raceTime.startTime) && Objects.equals(finishTime, raceTime.finishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, finishTime);
    }
}
