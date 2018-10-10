package ar.edu.uca.repositories;

import ar.edu.uca.entities.Pais;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PaisRepository extends CrudRepository<Pais, Integer> {
	@Transactional
    public Pais findPaisByNombre(String nombrePais);
	@Transactional
    public void removePaisByNombre(String nombrePais);
}
