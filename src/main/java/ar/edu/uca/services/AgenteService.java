package ar.edu.uca.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import ar.edu.uca.entities.dtos.EmpresaDTO;
import ar.edu.uca.repositories.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uca.entities.Agente;

/**
 * AgenteService
 * @author rdipasquale
 *
 */
//@Component
@Service
@Transactional
public class AgenteService {

	@Autowired 
	private AgenteRepository agenteRepository;
	
	public List<Agente> findAllAgente()
	{
		return (List<Agente>)agenteRepository.findAll();
	}
	
	public Agente findAgenteById(int id)
	{
		return agenteRepository.findOne(id);
	}
	
	public Agente saveAgente(Agente a)
	{
		agenteRepository.save(a);
		return a;
	}	
	
	@Transactional
	public Agente addAgenteFromEmpresa(EmpresaDTO e)
	{
		Agente a=new Agente();
		a.setFechaDesde(new Date());
		a.setNombre(e.getDescripcion());
		a.setTagId(1); // DEFAULT
		agenteRepository.save(a);
		return a;
	}
}
