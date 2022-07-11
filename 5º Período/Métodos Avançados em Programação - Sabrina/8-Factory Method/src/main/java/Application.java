import entities.hamburguerTypes.HamburgerXEgg;
import entities.hamburguerTypes.HamburgerBauru;
import entities.hamburguerTypes.HamburgerFitness;

public class Application {
    public static void main(String[] args) {

        HamburgerBauru hamburgerBauru = new HamburgerBauru();
        hamburgerBauru.setBreadType();
        hamburgerBauru.setCheeseType();
        hamburgerBauru.setHamType();
        hamburgerBauru.setEggType();
        hamburgerBauru.addTomato();
        System.out.println(hamburgerBauru);

        HamburgerXEgg hamburgerXEgg = new HamburgerXEgg();
        hamburgerXEgg.setBreadType();
        hamburgerXEgg.setCheeseType();
        hamburgerXEgg.setHamType();
        hamburgerXEgg.setEggType();
        hamburgerXEgg.addTomato();
        System.out.println(hamburgerXEgg);

        HamburgerFitness hamburgerFitness = new HamburgerFitness();
        hamburgerFitness.setBreadType();
        hamburgerFitness.setCheeseType();
        hamburgerFitness.setHamType();
        hamburgerFitness.setEggType();
        hamburgerFitness.addTomato();
        System.out.println(hamburgerFitness);
    }
}
