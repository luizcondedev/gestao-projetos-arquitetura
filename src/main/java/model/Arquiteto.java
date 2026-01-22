package model;

public class Arquiteto extends Pessoa{
    private String CAU;

    public Arquiteto(String nome, String email, String cpf, String CAU) {
        super(nome, email, cpf);
        this.CAU = CAU;
    }

    public String getCAU() {
        return CAU;
    }

    public void setCAU(String CAU) {
        this.CAU = CAU;
    }
}
