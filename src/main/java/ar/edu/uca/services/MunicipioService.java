package ar.edu.uca.services;

import ar.edu.uca.entities.Municipio;
import ar.edu.uca.entities.Pais;
import ar.edu.uca.entities.Provincia;
import ar.edu.uca.repositories.MunicipioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Objects.isNull;

@Service
@Transactional
public class MunicipioService {

    private MunicipioRepository municipioRepository;
    private ProvinciaService provinciaService;

    public MunicipioService(ProvinciaService provinciaService, MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
        this.provinciaService = provinciaService;
    }

    public Municipio crearMunicipio (String nombreMunicipio, String nombreProvincia, String nombrePais){

        Provincia provincia = provinciaService.buscarProvincia(nombreProvincia, nombrePais);
        if (isNull(provincia))
            return null;

        Municipio municipio = buscarMunicipio(nombreMunicipio, nombreProvincia, nombrePais);
        if (!isNull(municipio))
            return municipio;

        municipio = new Municipio(nombreMunicipio, provincia);
        return guardarMunicipio(municipio);

    }

    public Municipio guardarMunicipio(Municipio municipio) {
        return municipioRepository.save(municipio);
    }

    public Municipio buscarMunicipio(String nombreMunicipio, String nombreProvincia, String nombrePais) {
        return municipioRepository.findMunicipioByAndIdNombreAndIdProvinciaIdNombreAndIdProvinciaIdPaisNombre(nombreMunicipio, nombreProvincia, nombrePais);
    }
    
    public boolean borrarMunicipio(String nombreMunicipio, String nombreProvincia, String nombrePais) {
    	
    	Municipio municipio = this.buscarMunicipio(nombreMunicipio, nombreProvincia, nombrePais);
    	if (isNull(municipio))
    		return false;
    	municipioRepository.delete(municipio);
    	return true;
    }
}
