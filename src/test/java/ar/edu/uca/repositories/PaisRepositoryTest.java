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
public class PaisRepositoryTest {

    @Autowired
    private PaisRepository paisRepository;
//    @Autowired
//    private DependenciesLoader dependenciesLoader;

    @Before
    public void setUp() {
//        dependenciesLoader.setupTestEnvironment();
    }

    @Test
    public void buscarTest() {
        String nombrePais = "Argentina";
        Pais paisTest = new Pais();
        paisTest.setNombre(nombrePais);
        paisRepository.save(paisTest);
        Pais paisGuardado = paisRepository.findPaisByNombre(paisTest.getNombre());

        assertNotNull(paisRepository.findPaisByNombre(paisTest.getNombre()));
        assertEquals(paisTest.getNombre(), paisGuardado.getNombre());
    }

    @Test
    public void borrarPaisTest() {
        String nombrePais = "Uruguay";

        Pais paisTest = new Pais();
        paisTest.setNombre(nombrePais);
        paisRepository.save(paisTest);

        Pais paisGuardado = paisRepository.findPaisByNombre(paisTest.getNombre());

        assertNotNull(paisRepository.findPaisByNombre(paisGuardado.getNombre()));
        paisRepository.removePaisByNombre(paisTest.getNombre());

        assertNull(paisRepository.findPaisByNombre(paisGuardado.getNombre()));
    }
//    @Test
//    public void borrarPaisDebeBorrarSusProvinciasTest() {
//        String nombrePais = "Uruguay";
//
//        Pais paisTest = new Pais();
//        paisTest.setNombre(nombrePais);
//        
//        
//        
//        paisRepository.save(paisTest);
//
//        Pais paisGuardado = paisRepository.findPaisByNombre(paisTest.getNombre());
//
//        assertNotNull(paisRepository.findPaisByNombre(paisGuardado.getNombre()));
//        paisRepository.removePaisByNombre(paisTest.getNombre());
//
//        assertNull(paisRepository.findPaisByNombre(paisGuardado.getNombre()));
//    }

}


