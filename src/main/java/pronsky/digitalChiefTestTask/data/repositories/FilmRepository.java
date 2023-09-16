package pronsky.digitalChiefTestTask.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pronsky.digitalChiefTestTask.data.entities.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
