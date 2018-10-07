package ar.edu.uca.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uca.repositories.ProvinciaRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
public class ProvinciaServiceTest {

	@Autowired
	private PaisService paisService;
	@Autowired
	private ProvinciaService provinciaService;
	private ProvinciaRepository provinciaRepository;


	@Before
	public void setUp() {

	}

	@Test
	public void createProvinciaTest() {

		assertNotNull(paisService.crearPais("Argentina"));
		assertNotNull(provinciaService.createProvincia("Argentina", "Buenos Aires"));
		assertNotNull(provinciaService.createProvincia("Argentina", "Buenos Aires"));

	}
	@Test
	public void borrarProvinciaTest() {

		paisService.crearPais("Argentina");
		provinciaService.createProvincia("Argentina", "Buenos Aires");
		
		assertTrue(provinciaService.borrarProvincia("Buenos Aires","Argentina"));
		assertFalse(provinciaService.borrarProvincia("Mendoza","Argentina"));
	}



}
