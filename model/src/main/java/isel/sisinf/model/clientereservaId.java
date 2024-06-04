package isel.sisinf.model;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class clientereservaId implements Serializable {
    private Integer reserva;
    private Integer loja;
    private Integer cliente;

    // Construtores, Getters, Setters, hashCode e equals

    public clientereservaId() {}

    public clientereservaId(Integer reserva, Integer loja, Integer cliente) {
        this.reserva = reserva;
        this.loja = loja;
        this.cliente = cliente;
    }

    // Getters and setters

    public Integer getReserva() {return reserva;}

    public void setReserva(Integer reserva) {this.reserva = reserva;}

    public Integer getLoja() {return loja;}

    public void setLoja(Integer loja) {this.loja = loja;}

    public Integer getCliente() {return cliente;}

    public void setCliente(Integer cliente) {this.cliente = cliente;}

    // Override equals() and hashCode() methods if needed

}
