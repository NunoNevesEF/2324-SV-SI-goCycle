package isel.sisinf.model;

import jakarta.persistence.*;

@Entity
@Table(name = "loja")
public class loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "telefone", nullable = false)
    private int telefone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "localidade", nullable = false)
    private String localidade;

    @OneToOne
    @JoinColumn(name = "gestor", referencedColumnName = "id",unique = true)
    private pessoa gestor;


    // Getters e Setters

    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {this.endereco = endereco;}

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {this.localidade = localidade;}

    public pessoa getGestor() {return gestor;}

    public void setGestor(pessoa gestor) {this.gestor = gestor;}
}
