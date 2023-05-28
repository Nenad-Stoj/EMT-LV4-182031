package mk.ukim.finki.emt.runnerdata;

import mk.ukim.finki.emt.runnerdata.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/runners")
public class RunnerController {
    private final RunnerService runnerService;

    @Autowired
    public RunnerController(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @GetMapping
    public List<Runner> getAllRunners() {
        return runnerService.getAllRunners();
    }

    @PostMapping
    public Runner createRunner(@RequestBody Runner runner) {
        return runnerService.createRunner(runner);
    }

    @GetMapping("/{id}")
    public Runner getRunnerById(@PathVariable Long id) {
        return runnerService.getRunnerById(id);
    }

    @PutMapping("/{id}")
    public Runner updateRunner(@PathVariable Long id, @RequestBody Runner runner) {
        return runnerService.updateRunner(id, runner);
    }

    @DeleteMapping("/{id}")
    public void deleteRunner(@PathVariable Long id) {
        runnerService.deleteRunner(id);
    }
}
