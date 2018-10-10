package ar.edu.uca.repositories;

import ar.edu.uca.entities.Municipio;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface MunicipioRepository extends CrudRepository<Municipio, Integer> {

	@Transactional
    public Municipio findMunicipioByAndIdNombreAndIdProvinciaIdNombreAndIdProvinciaIdPaisNombre(String nombreMunicipio, String nombreProvincia, String nombrePais);
    
    @Transactional
	public void removeMunicipioByAndIdNombreAndIdProvinciaIdNombreAndIdProvinciaIdPaisNombre(String nombreMunicipio, String nombreProvincia, String nombrePais);

}
