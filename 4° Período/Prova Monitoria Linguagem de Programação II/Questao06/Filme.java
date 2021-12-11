package Questao06;

public class Filme {
    private String nome;
    private String autor;
    private int ano;
    private double preco;

    public Filme(String nome, String autor, int ano, double preco) {
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
