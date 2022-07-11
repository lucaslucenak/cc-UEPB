import entities.Hamburguer;
import entities.hamburguerTypes.HamburgerXEgg;
import entities.hamburguerTypes.HamburguerBauru;
import entities.hamburguerTypes.HamburguerFitness;

public class Application {
    public static void main(String[] args) {
//        Hamburguer hamburguer = new Hamburguer();
//        System.out.println(hamburguer.toString());

        HamburguerBauru hamburguerBauru = new HamburguerBauru();
        hamburguerBauru.setBreadType();
        hamburguerBauru.setCheeseType();
        hamburguerBauru.setHamType();
        hamburguerBauru.setEggType();
        hamburguerBauru.addTomato();
        System.out.println(hamburguerBauru);

        HamburgerXEgg hamburgerXEgg = new HamburgerXEgg();
        hamburgerXEgg.setBreadType();
        hamburgerXEgg.setCheeseType();
        hamburgerXEgg.setHamType();
        hamburgerXEgg.setEggType();
        hamburgerXEgg.addTomato();
        System.out.println(hamburgerXEgg);

        HamburguerFitness hamburguerFitness = new HamburguerFitness();
        hamburguerFitness.setBreadType();
        hamburguerFitness.setCheeseType();
        hamburguerFitness.setHamType();
        hamburguerFitness.setEggType();
        hamburguerFitness.addTomato();
        System.out.println(hamburguerFitness);
    }
}
