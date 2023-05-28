package mk.ukim.finki.racemanagement;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RaceService {
    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public Race getRaceById(Long id) {
        return raceRepository.findById(id).orElse(null);
    }

    public Race addRace(Race race) {
        return raceRepository.save(race);
    }

    public Race updateRace(Long id, Race updatedRace) {
        Race existingRace = raceRepository.findById(id).orElse(null);
        if (existingRace != null) {
            return raceRepository.save(updatedRace);
        }
        return null;
    }

    public boolean deleteRace(Long id) {
        Race race = raceRepository.findById(id).orElse(null);
        if (race != null) {
            raceRepository.delete(race);
            return true;
        }
        return false;
    }
}