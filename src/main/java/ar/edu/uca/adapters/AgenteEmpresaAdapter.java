//package ar.edu.uca.adapters;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import ar.edu.uca.entities.dtos.EmpresaDTO;
//import ar.edu.uca.entities.Agente;
//
//public class AgenteEmpresaAdapter {
//
//	public static EmpresaDTO adapt(Agente a)
//	{
//		if (a==null) return null;
//		EmpresaDTO e=new EmpresaDTO();
//		e.setNumero(a.getAgeId());
//		e.setDescripcion(a.getNombre());
//		return e;
//	}
//	
//	public static List<EmpresaDTO> adaptList(List<Agente> a)
//	{
//		if (a==null) return null;
//		List<EmpresaDTO> salida=new ArrayList<EmpresaDTO>();
//		for (Agente age : a) salida.add(adapt(age));
//		return salida;
//	}
//	
//}
