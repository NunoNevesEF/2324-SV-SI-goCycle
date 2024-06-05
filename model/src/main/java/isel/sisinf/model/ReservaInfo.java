package isel.sisinf.model;

public class ReservaInfo {
    private Integer numero;
    private String dtInicio;
    private String dtFim;
    private Double valor;
    private Integer bicicletaId;

    public ReservaInfo(Integer numero, String dtInicio, String dtFim, Double valor, Integer bicicletaId) {
        this.numero = numero;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.valor = valor;
        this.bicicletaId = bicicletaId;
    }

    // Getters e Setters

    @Override
    public String toString() {
        return "ReservaInfo{" +
                "numero=" + numero +
                ", dtInicio='" + dtInicio + '\'' +
                ", dtFim='" + dtFim + '\'' +
                ", valor=" + valor +
                ", bicicletaId=" + bicicletaId +
                '}';
    }
}