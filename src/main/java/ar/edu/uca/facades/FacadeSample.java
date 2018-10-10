//package ar.edu.uca.facades;
//
//import java.util.List;
//
//import ar.edu.uca.adapters.AgenteEmpresaAdapter;
//import ar.edu.uca.entities.dtos.EmpresaDTO;
//import ar.edu.uca.services.AgenteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class FacadeSample {
//
//	@Autowired
//	private AgenteService agenteService;
//	
//	@RequestMapping("/findAllEmpresas")
//	public List<EmpresaDTO> findAllEmpresas()
//	{
//		return AgenteEmpresaAdapter.adaptList(agenteService.findAllAgente());
//	}
//
//	@RequestMapping("/findEmpresaById")
//	public EmpresaDTO findEmpresasById(@RequestParam(value="id") Integer id)
//	{
//		return AgenteEmpresaAdapter.adapt(agenteService.findAgenteById(id));
//	}
//
//	@RequestMapping("/addEmpresaByName")
//	public EmpresaDTO addEmpresaByName(@RequestParam(value="name") String name)
//	{
//		if (name==null) return null;
//		EmpresaDTO e=new EmpresaDTO();
//		e.setDescripcion(name);
//		return AgenteEmpresaAdapter.adapt(agenteService.addAgenteFromEmpresa(e));
//	}
//		
//}
