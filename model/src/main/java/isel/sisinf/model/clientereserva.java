package isel.sisinf.model;

import jakarta.persistence.*;


@Entity
@Table(name = "clientereserva")
public class clientereserva {
    @ManyToOne
    @JoinColumn(name = "reserva", referencedColumnName = "numero", nullable = false)
    private reserva reserva;

    @ManyToOne
    @JoinColumn(name = "loja", referencedColumnName = "codigo", nullable = false)
    private loja loja;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private pessoa cliente;

    // Getters e Setters

    public reserva getReserva() {return reserva;}

    public void setReserva(reserva reserva) {this.reserva = reserva;}

    public loja getLoja() {return loja;}

    public void setLoja(loja loja) {this.loja = loja;}

    public pessoa getCliente() {return cliente;}

    public void setCliente(pessoa cliente) {this.cliente = cliente;}
}
