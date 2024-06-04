package isel.sisinf.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "reserva")
public class reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private String numero;

    @Column(name = "dtinicio", nullable = false)
    private Timestamp dtinicio;

    @Column(name = "dtfim")
    private Timestamp dtfim;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "bicicleta", referencedColumnName = "id", nullable = false)
    private bicicleta bicicleta;

    // Getters e Setters

    public String getNumero() {return numero;}

    public void setNumero(String numero) {this.numero = numero;}

    public Timestamp getDtinicio() {return dtinicio;}

    public void setDtinicio(Timestamp dtinicio) {this.dtinicio = dtinicio;}

    public Timestamp getDtfim() {return dtfim;}

    public void setDtfim(Timestamp dtfim) {this.dtfim = dtfim;}

    public BigDecimal getValor() {return valor;}

    public void setValor(BigDecimal valor) {this.valor = valor;}

    public bicicleta getBicicleta() {return bicicleta;}

    public void setBicicleta(bicicleta bicicleta) {this.bicicleta = bicicleta;}
}
