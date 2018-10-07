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

    public Tramo(){

    }

    public Tramo(Municipio municipioInicio, Municipio municipioFin) {
        this.id = new TramoId(municipioInicio, municipioFin);
    }


}
