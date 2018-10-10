package ar.edu.uca.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tramo")
public class Tramo {

    @EmbeddedId
    TramoId id;

    @Column(name = "kilometro_inicial")
    private int kilometroInicial;

    @Column(name = "kilometro_final")
    private int kilometroFinal;
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + kilometroFinal;
		result = prime * result + kilometroInicial;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tramo other = (Tramo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kilometroFinal != other.kilometroFinal)
			return false;
		if (kilometroInicial != other.kilometroInicial)
			return false;
		return true;
	}

	public Tramo(){
    }

    public Tramo(Municipio municipioInicio, Municipio municipioFin) {
        this.id = new TramoId(municipioInicio, municipioFin);
    }

    public TramoId getId() {
		return id;
	}

	public void setId(TramoId id) {
		this.id = id;
	}

	public int getKilometroInicial() {
		return kilometroInicial;
	}

	public void setKilometroInicial(int kilometroInicial) {
		this.kilometroInicial = kilometroInicial;
	}

	public int getKilometroFinal() {
		return kilometroFinal;
	}

	public void setKilometroFinal(int kilometroFinal) {
		this.kilometroFinal = kilometroFinal;
	}


}
