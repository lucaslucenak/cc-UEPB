package Questao10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Pessoa> listaPessoa = new ArrayList<Pessoa>();

    public void cadastrarPessoa(Pessoa pessoa) {
        listaPessoa.add(pessoa);
    }

    public void mostrarCadastro() {
        for(Pessoa pessoa : listaPessoa) {
            System.out.println(pessoa.mostraDados());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Pessoa pessoa = new Pessoa("Lucas", "010101");
        Pessoa cliente = new Cliente("Jucelio", "0202002", 2);
        Pessoa funcionario = new Funcionario("Danilo", "0303030", "3", 3560);
        Pessoa gerente = new Gerente("Jose", "040404", "4", 5640, 4);

        main.cadastrarPessoa(pessoa);
        main.cadastrarPessoa(cliente);
        main.cadastrarPessoa(funcionario);
        main.cadastrarPessoa(gerente);
        main.mostrarCadastro();
    }
}
