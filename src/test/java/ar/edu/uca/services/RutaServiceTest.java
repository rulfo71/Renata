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
import ar.edu.uca.entities.Municipio;
import ar.edu.uca.entities.Pais;
import ar.edu.uca.entities.Provincia;
import ar.edu.uca.entities.Ruta;
import ar.edu.uca.entities.Tramo;
import ar.edu.uca.repositories.MunicipioRepository;
import ar.edu.uca.repositories.PaisRepository;
import ar.edu.uca.repositories.ProvinciaRepository;
import ar.edu.uca.repositories.RutaRepository;
import ar.edu.uca.repositories.TramoRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
public class RutaServiceTest {

	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private PaisService paisService;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	@Autowired
	private ProvinciaService provinciaService;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private TramoService tramoService;
	@Autowired
	private TramoRepository tramoRepository;
	@Autowired
	private RutaRepository rutaRepository;
	@Autowired
	private RutaService rutaService;
	private Collection<Tramo> tramos = new ArrayList<>();
	private String nombrePais;
	private String nombreProvincia;
	private String nombreMunicipioInicioPrimerTramo;
	private String nombreMunicipioFinPrimerTramo;
	private String nombreMunicipioInicioSegundoTramo;
	private String nombreMunicipioFinSegundoTramo;
	
	private String tipoRuta;
	private int numeroRuta;
	
	

//	@Autowired
//	private DependenciesLoader dependenciesLoader;
//	
	@Before
	public void setUp() throws Exception {
//		dependenciesLoader.cleanDataBase();
	}

	@Test
	public void createRutaTest() {
		nombrePais = "Argentina";
//		paisService = new PaisService(paisRepository);
		Pais pais = paisService.crearPais(nombrePais);
		
		nombreProvincia = "Buenos Aires";
//		provinciaService = new ProvinciaService(paisService, provinciaRepository);
		Provincia provincia = provinciaService.crearProvincia(nombrePais, nombreProvincia);		
		
		nombreMunicipioInicioPrimerTramo = "Tigre";
		nombreMunicipioFinPrimerTramo = "Olivos";
		nombreMunicipioInicioSegundoTramo = "Olivos";
		nombreMunicipioFinSegundoTramo = "Florida";
		Municipio municipioInicioPrimerTramo = municipioService.crearMunicipio(nombreMunicipioInicioPrimerTramo, nombreProvincia, nombrePais);
		Municipio municipioFinPrimerTramo = municipioService.crearMunicipio(nombreMunicipioFinPrimerTramo, nombreProvincia, nombrePais);
		Municipio municipioInicioSegundoTramo = municipioService.crearMunicipio(nombreMunicipioInicioSegundoTramo, nombreProvincia, nombrePais);
		Municipio municipioFinSegundoTramo = municipioService.crearMunicipio(nombreMunicipioFinSegundoTramo, nombreProvincia, nombrePais);
		
		
		
		Tramo primerTramo = tramoService.crearTramo(nombreMunicipioInicioPrimerTramo, nombreProvincia, nombrePais, nombreMunicipioFinPrimerTramo, nombreProvincia, nombrePais);
		Tramo segundoTramo = tramoService.crearTramo(nombreMunicipioInicioSegundoTramo, nombreProvincia, nombrePais, nombreMunicipioFinSegundoTramo, nombreProvincia, nombrePais);
		tramos.add(primerTramo);
		tramos.add(segundoTramo);
		tipoRuta = "Provincial";
		numeroRuta = 2;
		Ruta ruta = rutaService.crearRuta(tipoRuta, numeroRuta, tramos);
		System.out.println(ruta.getTramos());
		
		assertNotNull(ruta);

	}
//	@Test
//	public void buscarRutaTest() {

//		paisService.crearPais("Argentina");
//		provinciaService.crearProvincia("Argentina", "Buenos Aires");
//		
//		assertTrue(provinciaService.borrarProvincia("Buenos Aires","Argentina"));
//		assertFalse(provinciaService.borrarProvincia("Mendoza","Argentina"));
		
//	}
//	@Test
//	public void borrarProvinciaNoBorrePaisTest() {
//		paisCreado = new Pais();
//		paisCreado.setNombre("Argentina");
//
//		paisService.crearPais("Argentina");
//		provinciaService.crearProvincia("Argentina", "Buenos Aires");
//		
//		paisDeBase = paisRepository.findPaisByNombre("Argentina");
//		assertEquals(paisCreado, paisDeBase);
//		
//	}
}
