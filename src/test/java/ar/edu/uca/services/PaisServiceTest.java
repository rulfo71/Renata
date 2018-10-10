package ar.edu.uca.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uca.DependenciesLoader;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.validation.constraints.AssertFalse;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
public class PaisServiceTest {
	@Autowired
	private PaisService paisService;
	@Autowired
	private ProvinciaService provinciaService;
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
	public void createCountryTest() {
		assertNotNull(paisService.crearPais("Argentina"));
		assertNotNull(paisService.crearPais("Argentina"));
	}
	
	@Test
	public void borrarPaisTest() {
		paisService.crearPais("Argentina");
		assertTrue(paisService.borrarPais("Argentina"));
		assertFalse(paisService.borrarPais("Uruguay"));	
	}

}
