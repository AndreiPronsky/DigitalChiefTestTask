package pronsky.digitalChiefTestTask.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pronsky.digitalChiefTestTask.data.entities.Film;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("FROM Film f WHERE f.title LIKE %:title%")
    Optional<Film> findByTitleContaining(String title);

    Optional<Film> findByYearOfRelease(Integer yearOfRelease);
}
