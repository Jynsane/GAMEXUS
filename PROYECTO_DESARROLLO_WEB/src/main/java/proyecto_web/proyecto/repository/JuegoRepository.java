package proyecto_web.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto_web.proyecto.model.Juego;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long> {

}
