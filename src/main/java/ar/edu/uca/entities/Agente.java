package ar.edu.uca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "AGENTES")
public class Agente {

    @Id
    @Column(name = "AGE_ID")
    @SequenceGenerator(name = "age_seq_ageId", sequenceName = "seq_ageId", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "age_seq_ageId")

    private int ageId;

    private String descripcion;

    private String nemo;

    @Column(name = "TAG_ID")
    private Integer tagId;

    @Column(name = "FECHA_DESDE")
    private Date fechaDesde;

    @Column(name = "FECHA_HASTA")
    private Date fechaHasta;

    public Agente() {

    }


    /**
     * @return the id
     */
    public int getAgeId() {
        return ageId;
    }

    /**
     * @param id the id to set
     */
    public void setAgeId(int id) {
        this.ageId = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return descripcion;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.descripcion = nombre;
    }

    /**
     * @return the nemo
     */
    public String getNemo() {
        return nemo;
    }

    /**
     * @param nemo the nemo to set
     */
    public void setNemo(String nemo) {
        this.nemo = nemo;
    }

    /**
     * @return the fechaDesde
     */
    public Date getFechaDesde() {
        return fechaDesde;
    }

    /**
     * @param fechaDesde the fechaDesde to set
     */
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    /**
     * @return the fechaHasta
     */
    public Date getFechaHasta() {
        return fechaHasta;
    }

    /**
     * @param fechaHasta the fechaHasta to set
     */
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public boolean getEstadoVigencia() {
        if (fechaHasta != null) {
            return true;
        } else {
            return false;
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Agente [id=" + ageId + ", nombre=" + descripcion + ", nemo=" + nemo
                + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta
                + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((fechaDesde == null) ? 0 : fechaDesde.hashCode());
        result = prime * result
                + ((fechaHasta == null) ? 0 : fechaHasta.hashCode());
        result = prime * result + ageId;
        result = prime * result + ((nemo == null) ? 0 : nemo.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Agente))
            return false;
        Agente other = (Agente) obj;
        if (ageId != other.ageId)
            return false;
        return true;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }


}
