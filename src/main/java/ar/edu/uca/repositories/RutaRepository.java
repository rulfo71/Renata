package ar.edu.uca.repositories;

import ar.edu.uca.entities.Ruta;
import ar.edu.uca.entities.Tramo;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface RutaRepository extends CrudRepository<Ruta, Integer> {
	
	@Transactional
	public Ruta findByIdNumeroAndIdTipo(int numero, String tipo);

}
