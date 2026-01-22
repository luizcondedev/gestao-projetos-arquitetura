package model;

public class Cliente extends Pessoa{
    private String telefoneContato;

    public Cliente(String nome, String email, String cpf, String telefoneContato){
        super(nome, email, cpf);
        this.telefoneContato = telefoneContato;
    }

    public String getTelefoneContato(){
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato){
        this.telefoneContato = telefoneContato;
    }
}
