package pronsky.digitalChiefTestTask.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pronsky.digitalChiefTestTask.data.entities.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Long> {

    Optional<Director> findByLastName(String lastName);

    Optional<Director> findByCountryOfBirth(String countryOfBirth);

    List<Director> findAllByYearOfBirth(Integer year);
}
