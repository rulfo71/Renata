package ar.edu.uca.repositories;

import ar.edu.uca.entities.Ruta;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface RutaRepository extends CrudRepository<Ruta, Integer> {

}
