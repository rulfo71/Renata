package ar.edu.uca.repositories;


import ar.edu.uca.DependenciesLoader;
import ar.edu.uca.entities.Municipio;
import ar.edu.uca.entities.Pais;
import ar.edu.uca.entities.Provincia;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
public class MunicipioRepositoryTest {

//    private static final HashSet<String> MUNICIPIOS_BUENOS_AIRES = new HashSet<>(Arrays.asList("San Isidro", "San Fernando", "Tigre", "Vicente Lopez"));
//    private boolean environmentLoaded;

    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
//    @Autowired
    private DependenciesLoader dependenciesLoader;

    @Before
    public void setUp() {
//        dependenciesLoader.cleanDataBase();
    }

    @Test
    public void buscarTest() {
        String nombrePais = "Argentina";
        Pais paisTest = new Pais();
        paisTest.setNombre(nombrePais);
        paisRepository.save(paisTest);

        String nombreProvincia = "Buenos Aires";
        Provincia provinciaTest = new Provincia(nombreProvincia, paisTest);
        provinciaRepository.save(provinciaTest);
        
        String nombreMunicipio = "Pacheco";
        Municipio municipioTest = new Municipio(nombreMunicipio,provinciaTest);
        municipioRepository.save(municipioTest);
        
        Municipio municipioGuardado = municipioRepository.findMunicipioByAndIdNombreAndIdProvinciaIdNombreAndIdProvinciaIdPaisNombre(nombreMunicipio, nombreProvincia, nombrePais);
        
        assertNotNull(municipioRepository.findMunicipioByAndIdNombreAndIdProvinciaIdNombreAndIdProvinciaIdPaisNombre(nombreMunicipio, nombreProvincia, nombrePais));
        assertEquals(municipioTest.getId().getNombre(),municipioGuardado.getId().getNombre());
    }

    @Test
    public void Test() {
        
        
        String nombrePais = "Uruguay";
        Pais paisTest = new Pais();
        paisTest.setNombre(nombrePais);
        paisRepository.save(paisTest);
        
        
        String nombreProvincia = "Cabo Polonio";
        Provincia provinciaTest = new Provincia(nombreProvincia, paisTest);
        provinciaRepository.save(provinciaTest);
        
        String nombreMunicipio = "Punta del diablo";
        Municipio municipioTest = new Municipio(nombreMunicipio, provinciaTest); 
        
        municipioRepository.removeMunicipioByAndIdNombreAndIdProvinciaIdNombreAndIdProvinciaIdPaisNombre(nombreMunicipio, nombreProvincia, nombrePais);
        
        assertNull(municipioRepository.findMunicipioByAndIdNombreAndIdProvinciaIdNombreAndIdProvinciaIdPaisNombre(nombreMunicipio, nombreProvincia, nombrePais));
    }
}


