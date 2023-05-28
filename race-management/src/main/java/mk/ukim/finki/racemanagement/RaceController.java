package mk.ukim.finki.racemanagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {
    private final RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping
    public List<Race> getAllRaces() {
        return raceService.getAllRaces();
    }

    @PostMapping
    public Race createRace(@RequestBody Race race) {
        return raceService.addRace(race);
    }

    @GetMapping("/{id}")
    public Race getRaceById(@PathVariable Long id) {
        return raceService.getRaceById(id);
    }

    @PutMapping("/{id}")
    public Race updateRace(@PathVariable Long id, @RequestBody Race race) {
        return raceService.updateRace(id, race);
    }

    @DeleteMapping("/{id}")
    public void deleteRace(@PathVariable Long id) {
        raceService.deleteRace(id);
    }
}

