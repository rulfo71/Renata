package ar.edu.uca.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ProvinciaId implements Serializable {

    @Column(name = "nombre_provincia")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nombre_pais", nullable = false)
    private Pais pais;

    public ProvinciaId() {
    }

    public ProvinciaId(String nombreProvincia, Pais pais) {
        this.nombre = nombreProvincia;
        this.pais = pais;
    }
}
