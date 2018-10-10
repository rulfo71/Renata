package ar.edu.uca;

import ar.edu.uca.entities.Municipio;
import ar.edu.uca.entities.Pais;
import ar.edu.uca.entities.Provincia;
import ar.edu.uca.repositories.MunicipioRepository;
import ar.edu.uca.repositories.PaisRepository;
import ar.edu.uca.repositories.ProvinciaRepository;
import ar.edu.uca.repositories.TramoRepository;
import ar.edu.uca.repositories.RutaRepository;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DependenciesLoader {

    private static boolean environmentLoaded;
    private static final HashSet<String> MUNICIPIOS_BUENOS_AIRES = new HashSet<>(Arrays.asList("San Isidro", "San Fernando", "Tigre", "Vicente Lopez"));

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private TramoRepository tramoRepository;
    @Autowired 
    private RutaRepository rutaRepository;

    public void setupTestEnvironment() {
        if (!environmentLoaded) {
            paisRepository.deleteAll();

            Pais pais = new Pais();
            pais.setNombre("Argentina");
            paisRepository.save(pais);

            Provincia provincia = new Provincia("Buenos Aires", pais);
            provinciaRepository.save(provincia);

            for (String nombreMunicipio : MUNICIPIOS_BUENOS_AIRES) {
                municipioRepository.save(new Municipio(nombreMunicipio, provincia));
            }
            environmentLoaded = true;
        }
    }
    public void cleanDataBase() {
    	paisRepository.deleteAll();
    	provinciaRepository.deleteAll();
    	municipioRepository.deleteAll();
    	tramoRepository.deleteAll();
    	rutaRepository.deleteAll();
    }
}
