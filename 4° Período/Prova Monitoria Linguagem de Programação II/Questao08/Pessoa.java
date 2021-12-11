package Questao08;

public class Pessoa {
    private String nome;
    private Data dataNasc;
    private Endereco endereco;
    private Contato contato;

    public Pessoa(String nome, Data dataNasc, Endereco endereco, Contato contato) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Data dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNasc=" + dataNasc +
                ", endereco=" + endereco +
                ", contato=" + contato +
                '}';
    }
}
