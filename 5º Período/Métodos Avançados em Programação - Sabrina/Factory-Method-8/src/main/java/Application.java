import entities.Hamburguer;
import entities.hamburguerTypes.HamburguerBauru;

public class Application {
    public static void main(String[] args) {
        Hamburguer hamburguer = new Hamburguer();
        System.out.println(hamburguer.toString());

        HamburguerBauru hamburguerBauru = new HamburguerBauru();
        hamburguerBauru.setBreadType();
        hamburguerBauru.setCheeseType();
        hamburguerBauru.setHamType();
        hamburguerBauru.setEggType();
        hamburguerBauru.addTomato();
        System.out.println(hamburguerBauru.toString());
    }
}
