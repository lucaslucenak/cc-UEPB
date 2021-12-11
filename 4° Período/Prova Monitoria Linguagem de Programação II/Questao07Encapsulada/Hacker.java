package Questao07Encapsulada;

public class Hacker {
    public static void main (String []args) {
        Usuario user1 = new Usuario("Lucas", "qwerty");
        //Exibição do nome de usuário e senha definidos acima

        //-------DESCOMENTAR O TRECHO DE CÓDIGO ABAIXO---------
        /*System.out.printf("""
                Login: %s
                Senha: %s""", user1.user, user1.password);

        //Alterando os dados definidos
        user1.user = "silvio";
        user1.password = "123456";

        //Exibição depois do usuário ter sido hackeado
        System.out.printf("""
                
                Hackeado!
                Login: %s
                Senha: %s""", user1.user, user1.password);*/
    }
}
