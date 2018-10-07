package ar.edu.uca.services;

import ar.edu.uca.entities.Pais;
import ar.edu.uca.entities.Provincia;
import ar.edu.uca.repositories.PaisRepository;
import ar.edu.uca.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Objects.isNull;

@Service
@Transactional
public class ProvinciaService {

    private PaisService paisService;
    private ProvinciaRepository provinciaRepository;

    public ProvinciaService(PaisService paisService, ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
        this.paisService = paisService;
    }

    @Transactional
    public Provincia createProvincia(String nombrePais, String nombreProvincia) {
        Pais pais = paisService.buscarPais(nombrePais);
        if (isNull(pais))
            return null;

        Provincia provincia = buscarProvincia(nombreProvincia, nombrePais);
        if (!isNull(provincia))
            return provincia;

        provincia = new Provincia(nombreProvincia, pais);
        return guardarProvincia(provincia);
    }

    public Provincia buscarProvincia(String nombreProvincia, String nombrePais){
        return provinciaRepository.findByIdNombreAndIdPaisNombre(nombreProvincia, nombrePais);
    }

    public Provincia guardarProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }
    public boolean borrarProvincia(String nombreProvincia, String nombrePais) {
        Provincia provincia = this.buscarProvincia(nombreProvincia, nombrePais);
        if (isNull(provincia))
        	return false;
        provinciaRepository.delete(provincia);
        return true; 
    }


}
