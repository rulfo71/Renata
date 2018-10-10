//package ar.edu.uca.repositories;
//
//import ar.edu.uca.entities.Agente;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
///**
// * Repositorio de Agentes
// *
// * @author rdipasquale
// */
//@Transactional
//public interface AgenteRepository extends CrudRepository<Agente, Integer> {
//
//    @Cacheable("basicCache")
//    @Query("select a FROM Agente a WHERE  a.fechaDesde<=SYSDATE and (a.fechaHasta is null or a.fechaHasta>trunc(SYSDATE)) order by a.ageId")
//    public List<Agente> findAgentesVigentes();
//
//}
