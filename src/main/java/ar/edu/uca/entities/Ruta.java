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
    RutaId rutaId;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private Collection<Tramo> tramos = new ArrayList<>();

}
