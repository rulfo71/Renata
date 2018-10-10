//package ar.edu.uca.repositories;
//
//import ar.edu.uca.DependenciesLoader;
//import ar.edu.uca.entities.Agente;
//import ar.edu.uca.repositories.AgenteRepository;
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
//public class AgenteRepositoryTest {
//
//    @Autowired
//    private AgenteRepository agenteRepository;
//    @Autowired
//    private DependenciesLoader dependenciesLoader;
//
//    @Before
//    public void setUp() {
//        dependenciesLoader.setupTestEnvironment();
//    }
//
//    @Test
//    public void addAgenteRepository() {
//
//        Agente agente = new Agente();
//        agente.setNombre("hola");
//        agenteRepository.save(agente);
//
//        for (Agente a : agenteRepository.findAll())
//            System.out.println(a);
//
//    }
//
//    @Test
//    public void testAgenteRepository() {
//
//        for (Agente a : agenteRepository.findAll())
//            System.out.println(a);
//
//    }
//
//
//}
