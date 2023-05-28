package mk.ukim.finki.racemanagement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
    // Additional custom methods if needed
}
