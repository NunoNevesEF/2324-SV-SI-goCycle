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
    private Integer numero;

    @Column(name = "dtinicio", nullable = false)
    private Timestamp dtinicio;

    @Column(name = "dtfim")
    private Timestamp dtfim;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "bicicleta", referencedColumnName = "id", nullable = false)
    private isel.sisinf.model.bicicleta bicicleta;

    // Getters e Setters

    public Integer getNumero() {return numero;}

    public void setNumero(Integer numero) {this.numero = numero;}

    public Timestamp getDtinicio() {return dtinicio;}

    public void setDtinicio(Timestamp dtinicio) {this.dtinicio = dtinicio;}

    public Timestamp getDtfim() {return dtfim;}

    public void setDtfim(Timestamp dtfim) {this.dtfim = dtfim;}

    public BigDecimal getValor() {return valor;}

    public void setValor(BigDecimal valor) {this.valor = valor;}

    public isel.sisinf.model.bicicleta getBicicleta() {return bicicleta;}

    public void setBicicleta(isel.sisinf.model.bicicleta bicicleta) {this.bicicleta = bicicleta;}

    public void setBicicletaId(Integer bicicletaId) {
        isel.sisinf.model.bicicleta bicicleta = new bicicleta();
        bicicleta.setId(bicicletaId);
        this.bicicleta = bicicleta;
    }
}
