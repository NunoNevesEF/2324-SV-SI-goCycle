package isel.sisinf.model;

public class BicicletaInfo {
    private Integer id;
    private String modelo;
    private double peso;
    private String marca;
    private String estado;
    private String sisMudancas;
    private char atrDisc;
    private Double velMax;
    private Double autonomia;
    private Integer gps;

    public BicicletaInfo(Integer id, String modelo, double peso, String marca, String estado,
                         String sisMudancas, char atrDisc, Double velMax, Double autonomia, Integer gps) {
        this.id = id;
        this.modelo = modelo;
        this.peso = peso;
        this.marca = marca;
        this.estado = estado;
        this.sisMudancas = sisMudancas;
        this.atrDisc = atrDisc;
        this.velMax = velMax;
        this.autonomia = autonomia;
        this.gps = gps;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getModelo() {return modelo;}

    public void setModelo(String modelo) {this.modelo = modelo;}

    public double getPeso() {return peso;}

    public void setPeso(double peso) {this.peso = peso;}

    public String getMarca() {return marca;}

    public void setMarca(String marca) {this.marca = marca;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public String getSisMudancas() {return sisMudancas;}

    public void setSisMudancas(String sisMudancas) {this.sisMudancas = sisMudancas;}

    public char getAtrDisc() {return atrDisc;}

    public void setAtrDisc(char atrDisc) {this.atrDisc = atrDisc;}

    public Double getVelMax() {return velMax;}

    public void setVelMax(Double velMax) {this.velMax = velMax;}

    public Double getAutonomia() {return autonomia;}

    public void setAutonomia(Double autonomia) {this.autonomia = autonomia;}

    public void setGps(Integer gps) {this.gps = gps;}

    public Integer getGps() {return gps;}

    @Override
    public String toString() {
        return "BicicletaInfo{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", peso=" + peso +
                ", marca='" + marca + '\'' +
                ", estado='" + estado + '\'' +
                ", sisMudancas='" + sisMudancas + '\'' +
                ", atrDisc=" + atrDisc +
                ", velMax=" + velMax +
                ", autonomia=" + autonomia +
                ", gps=" + gps +
                '}';
    }
}
