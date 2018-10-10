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

    public TramoId(){
    }

    public TramoId(Municipio municipioInicio, Municipio municipioFin) {
        this.municipioInicio = municipioInicio;
        this.municipioFin = municipioFin;
    }
}
