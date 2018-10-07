//package ar.edu.uca.repositories;
//
//import ar.edu.uca.entities.Agente;
//import ar.edu.uca.entities.Tramo;
//import ar.edu.uca.entities.TramoId;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Transactional
//public interface TramoRepository extends CrudRepository<Tramo, Integer> {
//
//    @Cacheable("basicCache")
//    public Tramo findTramoByTramoId(TramoId tramoId);
//
//}
