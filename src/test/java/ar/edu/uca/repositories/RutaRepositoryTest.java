package ar.edu.uca.repositories;


import ar.edu.uca.DependenciesLoader;
import ar.edu.uca.entities.Municipio;
import ar.edu.uca.entities.MunicipioId;
import ar.edu.uca.entities.Pais;
import ar.edu.uca.entities.Provincia;
import ar.edu.uca.entities.Ruta;
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
public class RutaRepositoryTest {

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
	@Autowired
	private RutaRepository rutaRepository;

    @Before
    public void setUp() {
//        dependenciesLoader.setupTestEnvironment(); 
    }

    @Test
    public void findRutaTest() {

    	String nombrePais = "Uruguay";
        Pais paisTest = new Pais();
        paisTest.setNombre(nombrePais);
        paisRepository.save(paisTest);
        
        String nombreProvincia = "Cabo Polonio";
        Provincia provinciaTest = new Provincia(nombreProvincia, paisTest);
        provinciaRepository.save(provinciaTest);
    	
    	String nombreMunicipioInicioPrimerTramo = "Punta del diablo";
        Municipio municipioInicioPrimerTramo = new Municipio(nombreMunicipioInicioPrimerTramo, provinciaTest);
        municipioRepository.save(municipioInicioPrimerTramo);

        String nombreMunicipioFinPrimerTramo = "Punta del este";
        Municipio municipioFinPrimerTramo = new Municipio(nombreMunicipioFinPrimerTramo, provinciaTest);
        municipioRepository.save(municipioFinPrimerTramo);
        
    	String nombreMunicipioInicioSegundoTramo = "Montevideo";
        Municipio municipioInicioSegundoTramo = new Municipio(nombreMunicipioInicioSegundoTramo, provinciaTest);
        municipioRepository.save(municipioInicioSegundoTramo);

        String nombreMunicipioFinSegundoTramo = "Rocha";
        Municipio municipioFinSegundoTramo = new Municipio(nombreMunicipioFinSegundoTramo, provinciaTest);
        municipioRepository.save(municipioFinSegundoTramo);
        
        Tramo primerTramo = new Tramo(municipioInicioPrimerTramo, municipioFinPrimerTramo);
        primerTramo.setKilometroInicial(10);
        primerTramo.setKilometroFinal(100);
        tramoRepository.save(primerTramo);
        
        Tramo segundoTramo = new Tramo(municipioInicioSegundoTramo, municipioFinSegundoTramo);
        segundoTramo.setKilometroInicial(100);
        segundoTramo.setKilometroFinal(200);
        tramoRepository.save(segundoTramo);
        
        String tipoDeRutaTest = "Nacional";
        int numeroDeRutaTest = 2;
        Ruta rutaTest = new Ruta(numeroDeRutaTest,tipoDeRutaTest);
        rutaRepository.save(rutaTest);
        
        Ruta rutaGuardada = rutaRepository.findByIdNumeroAndIdTipo(numeroDeRutaTest, tipoDeRutaTest);

        assertNotNull(rutaGuardada);
        assertEquals(rutaTest, rutaGuardada);
    }
}
	

