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
public class ProvinciaRepositoryTest {

//    private static final HashSet<String> MUNICIPIOS_BUENOS_AIRES = new HashSet<>(Arrays.asList("San Isidro", "San Fernando", "Tigre", "Vicente Lopez"));
//    private boolean environmentLoaded;

    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private PaisRepository paisRepository;
//    @Autowired
    private DependenciesLoader dependenciesLoader;

    @Before
    public void setUp() {
//        dependenciesLoader.cleanDataBase();
    }

    @Test
    public void guardarPaisTest() {
        String nombrePais = "Argentina";
        String nombreProvincia = "Buenos Aires";
        Pais paisTest = new Pais();
        paisTest.setNombre(nombrePais);
        paisRepository.save(paisTest);

        Provincia provinciaTest = new Provincia(nombreProvincia, paisTest);
        
        provinciaRepository.save(provinciaTest);
        
        Provincia provinciaGuardada = provinciaRepository.findByIdNombreAndIdPaisNombre(provinciaTest.getId().getNombre(),provinciaTest.getId().getPais().getNombre());
        
        assertNotNull(provinciaRepository.findByIdNombreAndIdPaisNombre(provinciaTest.getId().getNombre(),provinciaTest.getId().getPais().getNombre()));
        assertEquals(provinciaTest.getId().getNombre(),provinciaGuardada.getId().getNombre());
    }

    @Test
    public void borrarProvinciaTest() {
        String nombrePais = "Uruguay";
        String nombreProvincia = "Cabo Polonio";

        Pais paisTest = new Pais();
        paisTest.setNombre(nombrePais);
        paisRepository.save(paisTest);
        
        Provincia provinciaTest = new Provincia(nombreProvincia, paisTest);
        provinciaRepository.save(provinciaTest);
        provinciaRepository.removeByIdNombreAndIdPaisNombre(nombreProvincia, nombrePais);
        
        assertNull(provinciaRepository.findByIdNombreAndIdPaisNombre(nombreProvincia, nombrePais));
    }
}


