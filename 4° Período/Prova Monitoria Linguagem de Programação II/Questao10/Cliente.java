package Questao10;

public class Cliente extends Pessoa{
    protected int codigo;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, int codigo) {
        super(nome, cpf);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String mostraDados() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
