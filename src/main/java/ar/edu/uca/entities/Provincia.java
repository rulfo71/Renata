package ar.edu.uca.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {

    @EmbeddedId
    private ProvinciaId id;

    public Provincia() {
    }

    public Provincia(String nombreProvincia, Pais pais) {
        id = new ProvinciaId(nombreProvincia, pais);
    }

    public ProvinciaId getId() {
        return id;
    }

    public void setId(ProvinciaId id) {
        this.id = id;
    }
}
