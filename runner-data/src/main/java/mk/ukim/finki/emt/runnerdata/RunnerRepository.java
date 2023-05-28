package mk.ukim.finki.emt.runnerdata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RunnerRepository extends JpaRepository<Runner, Long> {
    // Additional custom methods if needed
}