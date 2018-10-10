package ar.edu.uca.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "ruta")
public class Ruta {

    @EmbeddedId
    private RutaId id;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<Tramo> tramos = new ArrayList<>();
    
    public Ruta() {
    	
    }
    public Ruta(int numero, String tipo) {
    	this.id = new RutaId(numero, tipo);
    }

	public RutaId getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tramos == null) ? 0 : tramos.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Ruta [id=" + id + ", tramos=" + tramos + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ruta other = (Ruta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tramos == null) {
			if (other.tramos != null)
				return false;
		} else if (!tramos.equals(other.tramos))
			return false;
		return true;
	}

	public void setRutaId(RutaId id) {
		this.id = id;
	}

	public Collection<Tramo> getTramos() {
		return tramos;
	}

	public void setTramos(Collection<Tramo> tramos) {
		this.tramos = tramos;
	}

}
