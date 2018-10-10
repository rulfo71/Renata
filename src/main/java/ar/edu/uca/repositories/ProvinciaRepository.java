package ar.edu.uca.repositories;

import ar.edu.uca.entities.Provincia;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ProvinciaRepository extends CrudRepository<Provincia, Integer> {

	@Transactional
    public Provincia findByIdNombreAndIdPaisNombre(String nombreProvincia, String nombrePais);
	@Transactional
	public void removeByIdNombreAndIdPaisNombre(String nombreProvincia, String nombrePais);
}
