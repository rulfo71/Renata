package ar.edu.uca.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "municipio")
public class Municipio {

    @EmbeddedId
    private MunicipioId id;

    public Municipio(String nombreMunicipio, Provincia provincia) {
        this.id = new MunicipioId(nombreMunicipio, provincia);
    }

    public Municipio() {
    }

    public MunicipioId getId() {
        return id;
    }

    public void setId(MunicipioId id) {
        this.id = id;
    }
}
