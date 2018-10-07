package ar.edu.uca.repositories;


import ar.edu.uca.DependenciesLoader;
import ar.edu.uca.entities.Municipio;
import ar.edu.uca.entities.MunicipioId;
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

    @Autowired
    private DependenciesLoader dependenciesLoader;

    @Before
    public void setupUp() {
        dependenciesLoader.setupTestEnvironment();
    }

    @Test
    public void findTramoByTramoIdTest() {

        MunicipioId municipioIdInicio = new MunicipioId();
        municipioIdInicio.setNombre("");

        Municipio municipioInicio = new Municipio();
        Municipio municipioFin = new Municipio();
//
//        municipioInicio.setId();
//
//        Tramo tramo = new Tramo();

    }


}


