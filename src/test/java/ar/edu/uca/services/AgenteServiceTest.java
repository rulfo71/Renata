//package ar.edu.uca.services;
//
//import ar.edu.uca.entities.Agente;
//import ar.edu.uca.services.AgenteService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@WebAppConfiguration
//public class AgenteServiceTest {
//
//	@Autowired
//	private AgenteService agenteService;
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void generateAgenteTest() {
//
//		Agente agente = new Agente();
//		agente.setNombre("hola");
//		agenteService.saveAgente(agente);
//	}
//
//
//}
