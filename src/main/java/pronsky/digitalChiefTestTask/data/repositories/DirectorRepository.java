package pronsky.digitalChiefTestTask.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pronsky.digitalChiefTestTask.data.entities.Director;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
