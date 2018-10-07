package ar.edu.uca.repositories;

import ar.edu.uca.entities.Tramo;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface TramoRepository extends CrudRepository<Tramo, Integer> {

    public Tramo findByIdMunicipioInicioIdNombreAndIdMunicipioInicioIdProvinciaIdNombreAndIdMunicipioInicioIdProvinciaIdPaisNombreAndIdMunicipioFinIdNombreAndIdMunicipioFinIdProvinciaIdNombreAndIdMunicipioFinIdProvinciaIdPaisNombre(String nombreMunicipioInicio, String nombreProvinciaInicio, String nombrePaisInicio, String nombreMunicipioFin, String nombreProvinciaFin, String nombrePaisFin);
}
