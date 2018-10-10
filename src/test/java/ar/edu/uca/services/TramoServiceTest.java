package ar.edu.uca.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uca.DependenciesLoader;
import ar.edu.uca.entities.Tramo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
public class TramoServiceTest {

	@Autowired
	private PaisService paisService;
	@Autowired
	private ProvinciaService provinciaService;
	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private TramoService tramoService;

//	@Autowired
//	private DependenciesLoader dependenciesLoader;

	private String nombrePais;
	private String nombreProvincia;
	private String nombreMunicipioInicio;
	private String nombreMunicipioFin;
	private int kilometroInicio;
	private int kilometroFin;
	
	private String tipoRuta;
	private int numeroRuta;

	@Before
	public void setUp() throws Exception {
		nombrePais = "Argentina";
		paisService.crearPais(nombrePais);

		nombreProvincia = "Buenos Aires";
		provinciaService.crearProvincia(nombrePais, nombreProvincia);		

		nombreMunicipioInicio = "Tigre";
		nombreMunicipioFin= "Olivos";

		municipioService.crearMunicipio(nombreMunicipioInicio, nombreProvincia, nombrePais);
		municipioService.crearMunicipio(nombreMunicipioFin, nombreProvincia, nombrePais);
		
		kilometroInicio = 0;
		kilometroFin = 100;

	}
	@Test
	public void crearTramoTest() {
		Tramo tramo = tramoService.crearTramo(kilometroInicio, kilometroFin, nombreMunicipioInicio, nombreProvincia, nombrePais, nombreMunicipioFin, nombreProvincia, nombrePais);
		assertNotNull(tramo);
	}

		@Test
		public void buscarTramoTest() {	
			Tramo tramoCreado = tramoService.crearTramo(kilometroInicio, kilometroFin, nombreMunicipioInicio, nombreProvincia, nombrePais, nombreMunicipioFin, nombreProvincia, nombrePais);
			
			Tramo tramoQueNoExiste = tramoService.buscarTramo("San Isidro", "Buenos Aires", "Argentina", "San Fernando", "Buenos Aires", "Argentina");
			Tramo tramoEncontrado = tramoService.buscarTramo(nombreMunicipioInicio, nombreProvincia, nombrePais, nombreMunicipioFin, nombreProvincia, nombrePais);
			
			assertNull(tramoQueNoExiste);
			assertNotNull(tramoEncontrado);
			assertEquals(tramoEncontrado, tramoCreado);
		}
}
