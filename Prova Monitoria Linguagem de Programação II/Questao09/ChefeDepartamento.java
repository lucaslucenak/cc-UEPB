package Questao09;

public class ChefeDepartamento extends Funcionario{
    private String departamento;
    private String dataPromocao;
    private Double gratificacao;

    public ChefeDepartamento(String nome, String cpf, String dataNasc, String matricula, String dataAdmissao, Double salario, String departamento, String dataPromocao, Double gratificacao) {
        super(nome, cpf, dataNasc, matricula, dataAdmissao, salario);
        this.departamento = departamento;
        this.dataPromocao = dataPromocao;
        this.gratificacao = gratificacao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDataPromocao() {
        return dataPromocao;
    }

    public void setDataPromocao(String dataPromocao) {
        this.dataPromocao = dataPromocao;
    }

    public Double getGratificacao() {
        return gratificacao;
    }

    public void setGratificacao(Double gratificacao) {
        this.gratificacao = gratificacao;
    }

    public void mostrarChefe() {
        System.out.println("Chefe:" +
                "\ndepartamento = " + departamento +
                "\ndataPromocao = " + dataPromocao +
                "\ngratificacao = " + gratificacao);
    }
}
