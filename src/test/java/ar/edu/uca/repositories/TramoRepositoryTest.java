package ar.edu.uca.repositories;


import ar.edu.uca.DependenciesLoader;
import ar.edu.uca.entities.Municipio;
import ar.edu.uca.entities.MunicipioId;
import ar.edu.uca.entities.Pais;
import ar.edu.uca.entities.Provincia;
import ar.edu.uca.entities.Tramo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
public class TramoRepositoryTest {

//    @Autowired
//    private DependenciesLoader dependenciesLoader;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private TramoRepository tramoRepository;

    @Before
    public void setUp() {
//        dependenciesLoader.setupTestEnvironment(); 
    }

    @Test
    public void findTramoTest() {

    	String nombrePais = "Uruguay";
        Pais paisTest = new Pais();
        paisTest.setNombre(nombrePais);
        paisRepository.save(paisTest);
        
        
        String nombreProvincia = "Cabo Polonio";
        Provincia provinciaTest = new Provincia(nombreProvincia, paisTest);
        provinciaRepository.save(provinciaTest);
    	
    	String nombreMunicipioInicio = "Punta del diablo";
        Municipio municipioInicio = new Municipio(nombreMunicipioInicio, provinciaTest);
        municipioRepository.save(municipioInicio);

        String nombreMunicipioFin = "Punta del este";
        Municipio municipioFin = new Municipio(nombreMunicipioFin, provinciaTest);
        municipioRepository.save(municipioFin);
        
        Tramo tramoTest = new Tramo(municipioInicio, municipioFin);
        tramoTest.setKilometroInicial(10);
        tramoTest.setKilometroFinal(100);
        tramoRepository.save(tramoTest);
        
        Tramo tramoGuardado = tramoRepository.findByIdMunicipioInicioIdNombreAndIdMunicipioInicioIdProvinciaIdNombreAndIdMunicipioInicioIdProvinciaIdPaisNombreAndIdMunicipioFinIdNombreAndIdMunicipioFinIdProvinciaIdNombreAndIdMunicipioFinIdProvinciaIdPaisNombre(nombreMunicipioInicio, nombreProvincia, nombrePais, nombreMunicipioFin, nombreProvincia, nombrePais);
        
        assertNotNull(tramoRepository.findByIdMunicipioInicioIdNombreAndIdMunicipioInicioIdProvinciaIdNombreAndIdMunicipioInicioIdProvinciaIdPaisNombreAndIdMunicipioFinIdNombreAndIdMunicipioFinIdProvinciaIdNombreAndIdMunicipioFinIdProvinciaIdPaisNombre(nombreMunicipioInicio, nombreProvincia, nombrePais, nombreMunicipioFin, nombreProvincia, nombrePais));
        assertEquals(tramoTest.getId().getMunicipioInicio(),tramoGuardado.getId().getMunicipioInicio());
    }
}
	

