package model;

public class Projeto {
    private String nomeProjeto;
    private String enderecoProjeto;
    private String faseDoProjeto;
    private Arquiteto arquitetoResponsavel;
    private Cliente cliente;
    private int id;

    public Projeto(String nomeProjeto, String enderecoProjeto,String faseDoProjeto, Arquiteto arquitetoResponsavel, Cliente cliente){
        this.nomeProjeto = nomeProjeto;
        this.enderecoProjeto = enderecoProjeto;
        this.faseDoProjeto = faseDoProjeto;
        this.arquitetoResponsavel = arquitetoResponsavel;
        this.cliente = cliente;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getEnderecoProjeto() {
        return enderecoProjeto;
    }

    public void setEnderecoProjeto(String enderecoProjeto) {
        this.enderecoProjeto = enderecoProjeto;
    }

    public Arquiteto getArquitetoResponsavel() {
        return arquitetoResponsavel;
    }

    public void setArquitetoResponsavel(Arquiteto arquitetoResponsavel) {
        this.arquitetoResponsavel = arquitetoResponsavel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFaseDoProjeto() {
        return faseDoProjeto;
    }

    public void setFaseDoProjeto(String faseDoProjeto) {
        this.faseDoProjeto = faseDoProjeto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
