//package ar.edu.uca.services;
//
//import ar.edu.uca.entities.Tramo;
//import ar.edu.uca.repositories.TramoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//import static java.util.Objects.isNull;
//
//@Service
//@Transactional
//public class TramoService {
//
//    @Autowired
//    private TramoRepository tramoRepository;
//
//    public boolean existeElTramo(Tramo tramo) {
//        return !isNull(tramoRepository.findTramoByTramoId(tramo.getTramoId()));
//    }
//
//}
