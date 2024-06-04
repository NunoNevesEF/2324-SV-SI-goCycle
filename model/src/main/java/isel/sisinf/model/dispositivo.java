package isel.sisinf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dispositivo")
public class dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noserie")
    private String noserie;

    @Column(name = "bateria", nullable = false)
    private double bateria;

    @Column(name = "latitude", nullable = false)
    private float latitude;

    @Column(name = "longitude", nullable = false)
    private float longitude;

    // Getters e Setters

    public String getNoserie() { return noserie; }

    public void setNoserie(String noserie) {this.noserie = noserie;}

    public double getBateria() {return bateria;}

    public void setBateria(double bateria) {this.bateria = bateria;}

    public float getLatitude() {return latitude;}

    public void setLatitude(float latitude) {this.latitude = latitude;}

    public float getLongitude() {return longitude;}

    public void setLongitude(float longitude) {this.longitude = longitude;}
}
