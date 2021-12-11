package Questao09;

public class Funcionario extends Pessoa{
    private String matricula;
    private String dataAdmissao;
    private Double salario;

    public Funcionario(String nome, String cpf, String dataNasc, String matricula, String dataAdmissao, Double salario) {
        super(nome, cpf, dataNasc);
        this.matricula = matricula;
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void mostrarFuncionario() {
        System.out.println("Funcionario:" +
                "\nmatricula = " + matricula +
                "\ndataAdmissao = " + dataAdmissao +
                "\nsalario = " + salario);
    }
}
