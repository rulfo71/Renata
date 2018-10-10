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
import ar.edu.uca.entities.Pais;
import ar.edu.uca.repositories.PaisRepository;
import ar.edu.uca.repositories.ProvinciaRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
public class ProvinciaServiceTest {

	@Autowired
	private PaisService paisService;
	@Autowired
	private ProvinciaService provinciaService;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	private Pais paisCreado;
	private Pais paisDeBase;

	@Autowired
	private DependenciesLoader dependenciesLoader;
	
	@Before
	public void setUp() throws Exception {
		dependenciesLoader.cleanDataBase();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createProvinciaTest() {

		assertNotNull(paisService.crearPais("Argentina"));
		assertNotNull(provinciaService.crearProvincia("Argentina", "Buenos Aires"));
		assertNotNull(provinciaService.crearProvincia("Argentina", "Buenos Aires"));

	}
	@Test
	public void borrarProvinciaTest() {
		paisCreado = new Pais();
		paisCreado.setNombre("Argentina");

		paisService.crearPais("Argentina");
		provinciaService.crearProvincia("Argentina", "Buenos Aires");
		
		assertTrue(provinciaService.borrarProvincia("Buenos Aires","Argentina"));
		assertFalse(provinciaService.borrarProvincia("Mendoza","Argentina"));
		
		paisDeBase = paisRepository.findPaisByNombre("Argentina");
		assertEquals(paisCreado, paisDeBase);
		
	}
}
