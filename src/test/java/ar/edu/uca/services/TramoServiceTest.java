package ar.edu.uca.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;


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


	@Before
	public void setUp() {

	}

	@Test
	public void buscarTramoTest() {
		tramoService.buscarTramo("San Isidro", "Buenos Aires", "Argentina", "San Fernando", "Buenos Aires", "Argentina");

	}
}
