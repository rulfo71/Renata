package ar.edu.uca.services;

import ar.edu.uca.entities.Municipio;
import ar.edu.uca.entities.Provincia;
import ar.edu.uca.entities.Tramo;
import ar.edu.uca.repositories.TramoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Objects.isNull;

@Service
@Transactional
public class TramoService {

    private MunicipioService municipioService;
    private TramoRepository tramoRepository;

    public TramoService(MunicipioService municipioService, TramoRepository tramoRepository) {
        this.municipioService = municipioService;
        this.tramoRepository = tramoRepository;
    }

    public Tramo crearTramo(String nombreMunicipioInicio, String nombreProvinciaInicio, String nombrePaisInicio, String nombreMunicipioFin, String nombreProvinciaFin, String nombrePaisFin){

        Municipio municipioInicio =  municipioService.buscarMunicipio(nombreMunicipioInicio, nombreProvinciaInicio, nombrePaisInicio);
        if (isNull(municipioInicio))
            return null;

        Municipio municipioFin = municipioService.buscarMunicipio(nombreMunicipioFin, nombreProvinciaFin, nombrePaisFin);
        if (isNull(municipioFin))
            return null;

        Tramo tramo = buscarTramo(nombreMunicipioInicio, nombreProvinciaInicio, nombrePaisInicio, nombreMunicipioFin, nombreProvinciaFin, nombrePaisFin);
        if (!isNull(tramo))
            return tramo;

        tramo = new Tramo(municipioInicio, municipioFin);
        return guardarTramo(tramo);

    }

    public Tramo guardarTramo(Tramo tramo){
        return tramoRepository.save(tramo);
    }

    public Tramo buscarTramo(String nombreMunicipioInicio, String nombreProvinciaInicio, String nombrePaisInicio, String nombreMunicipioFin, String nombreProvinciaFin, String nombrePaisFin) {
        return tramoRepository.findByIdMunicipioInicioIdNombreAndIdMunicipioInicioIdProvinciaIdNombreAndIdMunicipioInicioIdProvinciaIdPaisNombreAndIdMunicipioFinIdNombreAndIdMunicipioFinIdProvinciaIdNombreAndIdMunicipioFinIdProvinciaIdPaisNombre(nombreMunicipioInicio, nombreProvinciaInicio, nombrePaisInicio, nombreMunicipioFin, nombreProvinciaFin, nombrePaisFin);
    }

}
