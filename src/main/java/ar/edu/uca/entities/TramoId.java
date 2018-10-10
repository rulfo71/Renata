package ar.edu.uca.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Embeddable
public class TramoId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "nombre_municipio_inicio", referencedColumnName = "nombre_municipio"),
            @JoinColumn(name = "nombre_provincia_inicio", referencedColumnName = "nombre_provincia"),
            @JoinColumn(name = "nombre_pais_inicio", referencedColumnName = "nombre_pais")
    })
    private Municipio municipioInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "nombre_municipio_fin", referencedColumnName = "nombre_municipio"),
            @JoinColumn(name = "nombre_provincia_fin", referencedColumnName = "nombre_provincia"),
            @JoinColumn(name = "nombre_pais_fin", referencedColumnName = "nombre_pais")
    })
    private Municipio municipioFin;

    public Municipio getMunicipioInicio() {
		return municipioInicio;
	}

	public void setMunicipioInicio(Municipio municipioInicio) {
		this.municipioInicio = municipioInicio;
	}

	public Municipio getMunicipioFin() {
		return municipioFin;
	}

	public void setMunicipioFin(Municipio municipioFin) {
		this.municipioFin = municipioFin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((municipioFin == null) ? 0 : municipioFin.hashCode());
		result = prime * result + ((municipioInicio == null) ? 0 : municipioInicio.hashCode());
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
		TramoId other = (TramoId) obj;
		if (municipioFin == null) {
			if (other.municipioFin != null)
				return false;
		} else if (!municipioFin.equals(other.municipioFin))
			return false;
		if (municipioInicio == null) {
			if (other.municipioInicio != null)
				return false;
		} else if (!municipioInicio.equals(other.municipioInicio))
			return false;
		return true;
	}

	public TramoId(){
    }

    public TramoId(Municipio municipioInicio, Municipio municipioFin) {
        this.municipioInicio = municipioInicio;
        this.municipioFin = municipioFin;
    }
}
