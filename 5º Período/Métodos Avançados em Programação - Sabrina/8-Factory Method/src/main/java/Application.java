import entities.hamburguerTypes.HamburgerXEgg;
import entities.hamburguerTypes.HamburgerBauru;
import entities.hamburguerTypes.HamburgerFitness;

public class Application {
    public static void main(String[] args) {

        HamburgerBauru hamburgerBauru = new HamburgerBauru();
        hamburgerBauru.setBread(hamburgerBauru.breadFactory());
        hamburgerBauru.breadFactory();
        hamburgerBauru.cheeseFactory();
        hamburgerBauru.setHamType();
        hamburgerBauru.eggFactory();
        hamburgerBauru.addTomato();
        System.out.println(hamburgerBauru.getBread().getBreadTypeEnum());

        HamburgerXEgg hamburgerXEgg = new HamburgerXEgg();
        hamburgerXEgg.breadFactory();
        hamburgerXEgg.cheeseFactory();
        hamburgerXEgg.setHamType();
        hamburgerXEgg.eggFactory();
        hamburgerXEgg.addTomato();
//        System.out.println(hamburgerXEgg.toString());

        HamburgerFitness hamburgerFitness = new HamburgerFitness();
        hamburgerFitness.breadFactory();
        hamburgerFitness.cheeseFactory();
        hamburgerFitness.setHamType();
        hamburgerFitness.eggFactory();
        hamburgerFitness.addTomato();
//        System.out.println(hamburgerFitness.toString());
    }
}
