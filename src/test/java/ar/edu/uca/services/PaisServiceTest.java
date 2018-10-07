package ar.edu.uca.services;

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
public class PaisServiceTest {

	@Autowired
	private PaisService paisService;

	@Test
	public void createCountryTest() {
		assertNotNull(paisService.crearPais("Argentina"));
		assertNotNull(paisService.crearPais("Argentina"));
	}


}
