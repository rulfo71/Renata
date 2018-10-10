package ar.edu.uca.services;

import ar.edu.uca.entities.Pais;
import ar.edu.uca.entities.Ruta;
import ar.edu.uca.entities.Tramo;
import ar.edu.uca.repositories.PaisRepository;
import ar.edu.uca.repositories.RutaRepository;
import ar.edu.uca.repositories.TramoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Objects.isNull;

import java.util.Collection;

@Service
@Transactional
public class RutaService {

	@Autowired
	private RutaRepository rutaRepository;
	@Autowired
	private TramoService tramoService;
	
    public RutaService(TramoService tramoService, RutaRepository rutaRepository) {
        this.tramoService = tramoService;
        this.rutaRepository = rutaRepository;
    }

	@Transactional
	public Ruta crearRuta(String tipo, int numero, Collection<Tramo> tramos) {

		if (isNull(tipo)) {
			return null;
		}
		
		if (isNull(numero)) {
			return null;
		}
		
		Ruta ruta = buscarRuta(tipo, numero);
		if (!isNull(ruta)) {
			return ruta;
		}
		
		ruta = new Ruta(numero,tipo);
		ruta.setTramos(tramos);
		
		return guardarRuta(ruta);
	}
	
    public Ruta guardarRuta(Ruta ruta){
        return rutaRepository.save(ruta);
    }
	
	public Ruta buscarRuta(String tipo, int numero) {
		return rutaRepository.findByIdNumeroAndIdTipo(numero, tipo);
	}

}
