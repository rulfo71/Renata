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

import java.util.Arrays;
import java.util.HashSet;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
public class PaisRepositoryTest {

    private static final HashSet<String> MUNICIPIOS_BUENOS_AIRES = new HashSet<>(Arrays.asList("San Isidro", "San Fernando", "Tigre", "Vicente Lopez"));
    private boolean environmentLoaded;

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private DependenciesLoader dependenciesLoader;

    @Before
    public void setUp() {
        dependenciesLoader.setupTestEnvironment();
    }

    @Test
    public void findPaisByNombreTest() {
        System.out.println("Used entities in test: ");
        for (Pais pais : paisRepository.findAll()) {
            System.out.println(String.format("Nombre: %s", pais.getNombre()));
        }
    }


//
//    @Test
//    public void saveTest() {
//        String nombrePais = "Argentina";
//
//        Pais paisTest = new Pais();
//        paisTest.setNombrePais(nombrePais);
//        paisRepository.save(paisTest);
//
//        Pais paisGuardado = paisRepository.findOne(paisTest.getPaisId());
//
//        assertNotNull(paisRepository.findOne(paisGuardado.getPaisId()));
//        assertEquals(paisTest.getPaisId(), paisGuardado.getPaisId());
//        assertEquals(paisTest.getNombrePais(), paisGuardado.getNombrePais());
//
//    }
//
//    @Test
//    public void deleteTest() {
//        String nombrePais = "Uruguay";
//
//        Pais paisTest = new Pais();
//        paisTest.setNombrePais(nombrePais);
//        paisRepository.save(paisTest);
//
//        Pais paisGuardado = paisRepository.findOne(paisTest.getPaisId());
//
//        assertNotNull(paisRepository.findOne(paisGuardado.getPaisId()));
//        paisRepository.delete(paisTest.getPaisId());
//
//        assertNull(paisRepository.findOne(paisGuardado.getPaisId()));
//
//    }

}


