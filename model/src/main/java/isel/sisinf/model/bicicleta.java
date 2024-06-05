package isel.sisinf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bicicleta")
public class bicicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "sis_mudancas", nullable = false)
    private String sis_mudancas;

    @Column(name = "atr_disc", nullable = false)
    private Character atr_disc;

    @Column(name = "vel_max")
    private double vel_max;

    @Column(name = "autonomia")
    private double autonomia;

    @OneToOne
    @JoinColumn(name = "gps", referencedColumnName = "noserie", unique = true, nullable = false)
    private dispositivo gps;

    // Getters e Setters

    public Integer getId() { return id; }

    public void setId(Integer id) {this.id = id;}

    public String getModelo() {return modelo;}

    public void setModelo(String modelo) {this.modelo = modelo;}

    public double getPeso() {return peso;}

    public void setPeso(double peso) {this.peso = peso;}

    public String getMarca() {return marca;}

    public void setMarca(String marca) {this.marca = marca;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public String getSisMudancas() {return sis_mudancas;}

    public void setSisMudancas(String sisMudancas) {this.sis_mudancas = sisMudancas;}

    public Character getAtrDisc() {return atr_disc;}

    public void setAtrDisc(Character atrDisc) {this.atr_disc = atrDisc;}

    public double getVelMax() {return vel_max;}

    public void setVelMax(double velMax) {this.vel_max = velMax;}

    public double getAutonomia() {return autonomia;}

    public void setAutonomia(double autonomia) {this.autonomia = autonomia;}

    public dispositivo getGps() {return gps;}

    public void setGps(dispositivo gps) {this.gps = gps;}

}
