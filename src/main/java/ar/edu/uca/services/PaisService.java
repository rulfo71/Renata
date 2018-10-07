package ar.edu.uca.services;

import ar.edu.uca.entities.Pais;
import ar.edu.uca.repositories.PaisRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Objects.isNull;

@Service
@Transactional
public class PaisService {

    private PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Transactional
    public Pais guardarPais(Pais pais) {
        paisRepository.save(pais);
        return pais;
    }

    @Transactional
    public Pais crearPais(String nombrePais) {
        Pais pais = buscarPais(nombrePais);
        if (!isNull(pais))
            return pais;

        pais = new Pais();
        pais.setNombre(nombrePais);
        return guardarPais(pais);
    }

    public Pais buscarPais(String nombrePais) {
        return paisRepository.findPaisByNombre(nombrePais);
    }
    
    public boolean borrarPais(String nombrePais) {
        Pais pais = paisRepository.findPaisByNombre(nombrePais);
        if (isNull(pais)) {
        	return false; 
        }
        paisRepository.delete(pais);
        return true;
    }


}
