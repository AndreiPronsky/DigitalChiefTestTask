package pronsky.digitalChiefTestTask.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pronsky.digitalChiefTestTask.data.entities.Film;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {

    Optional<Film> findByTitle(String title);

    Optional<Film> findByYearOfRelease(Integer yearOfRelease);
}
