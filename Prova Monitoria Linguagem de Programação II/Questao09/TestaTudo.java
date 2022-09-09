package Questao09;

public class TestaTudo {
    public static void main(String []args) {
        Pessoa pessoa = new Pessoa("Lucas", "123", "19/11/01");
        Funcionario funcionario = new Funcionario("Lucas", "1234", "19/11/01", "00001", "09/11/21", 9999.9);
        Aluno aluno = new Aluno("Lucas", "123", "19/11/01", "0002");
        ChefeDepartamento chefeDepartamento = new ChefeDepartamento("Lucas", "123", "19/11/01",
                "0001", "09/11/21", 99999.9, "Financeiro", "10/11/21",
                500.50);
        pessoa.mostrarPessoa();
        funcionario.mostrarFuncionario();
        chefeDepartamento.mostrarChefe();
        aluno.mostrarAluno();
    }
}
