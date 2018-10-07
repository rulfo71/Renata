package ar.edu.uca.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class MunicipioId implements Serializable {

    @Column(name = "nombre_municipio")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="nombre_pais", referencedColumnName="nombre_pais"),
            @JoinColumn(name="nombre_provincia", referencedColumnName="nombre_provincia")
            })
    private Provincia provincia;


    public MunicipioId() {
    }

    public MunicipioId(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}
