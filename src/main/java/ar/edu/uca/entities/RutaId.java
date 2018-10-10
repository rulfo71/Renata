package ar.edu.uca.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RutaId implements Serializable {

    @Column(name = "numero")
    private int numero;

    @Column(name = "tipo")
    private String tipo;

    public int getNumero() {
        return numero;
    }
    
    public RutaId() {
    	
    }
    
    public RutaId(int numero, String tipo){
    	this.numero = numero;
    	this.tipo = tipo;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		RutaId other = (RutaId) obj;
		if (numero != other.numero)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
