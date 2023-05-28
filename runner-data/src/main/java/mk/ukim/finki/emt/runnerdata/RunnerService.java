package mk.ukim.finki.emt.runnerdata;


import jakarta.transaction.Transactional;
import mk.ukim.finki.racemanagement.Race;
import mk.ukim.finki.racemanagement.RaceRepository;
import mk.ukim.finki.emt.sharedkernel.RaceTime;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class RunnerService {
    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;

    public RunnerService(RunnerRepository runnerRepository, RaceRepository raceRepository) {
        this.runnerRepository = runnerRepository;
        this.raceRepository = raceRepository;
    }

    public List<Runner> getAllRunners() {
        return runnerRepository.findAll();
    }

    public Runner getRunnerById(Long id) {
        return runnerRepository.findById(id).orElse(null);
    }

    public Runner addRunner(Runner runner) {
        return runnerRepository.save(runner);
    }

    public Runner updateRunner(Long id, Runner updatedRunner) {
        Runner existingRunner = runnerRepository.findById(id).orElse(null);
        if (existingRunner != null) {
            return runnerRepository.save(updatedRunner);
        }
        return null;
    }

    public boolean deleteRunner(Long id) {
        Runner runner = runnerRepository.findById(id).orElse(null);
        if (runner != null) {
            runnerRepository.delete(runner);
            return true;
        }
        return false;
    }

    public void startRace(Long runnerId, Long raceId) {
        Runner runner = runnerRepository.findById(runnerId).orElse(null);
        Race race = raceRepository.findById(raceId).orElse(null);

        if (runner != null && race != null) {
            RaceTime raceTime = new RaceTime();
            raceTime.setStartTime(LocalDateTime.now());

            runner.setRaceTime(raceTime);
            race.addRunner(runner);

            runnerRepository.save(runner);
            raceRepository.save(race);
        }
    }

    public void finishRace(Long runnerId) {
        Runner runner = runnerRepository.findById(runnerId).orElse(null);

        if (runner != null && runner.getRaceTime() != null) {
            RaceTime raceTime = runner.getRaceTime();
            raceTime.setFinishTime(LocalDateTime.now());

            runnerRepository.save(runner);
        }
    }

    public String getFullTime(Long runnerId) {
        Runner runner = runnerRepository.findById(runnerId).orElse(null);

        if (runner != null && runner.getRaceTime() != null) {
            RaceTime raceTime = runner.getRaceTime();
            return raceTime.calculateElapsedTime().toString();
        }

        return null;
    }

}
