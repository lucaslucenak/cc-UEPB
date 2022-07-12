import entities.hamburguerTypes.HamburgerXEgg;
import entities.hamburguerTypes.HamburgerBauru;
import entities.hamburguerTypes.HamburgerFitness;

public class Application {
    public static void main(String[] args) {

        HamburgerBauru hamburgerBauru = new HamburgerBauru();
        hamburgerBauru.setBread(hamburgerBauru.breadFactory());
        hamburgerBauru.setCheese(hamburgerBauru.cheeseFactory());
        hamburgerBauru.setHam(hamburgerBauru.hamFactory());
        hamburgerBauru.setEgg(hamburgerBauru.eggFactory());
        hamburgerBauru.setTomato(hamburgerBauru.tomatoFactory());
        System.out.println(hamburgerBauru);

        HamburgerXEgg hamburgerXEgg = new HamburgerXEgg();
        hamburgerXEgg.setBread(hamburgerXEgg.breadFactory());
        hamburgerXEgg.setCheese(hamburgerXEgg.cheeseFactory());
        hamburgerXEgg.setHam(hamburgerXEgg.hamFactory());
        hamburgerXEgg.setEgg(hamburgerXEgg.eggFactory());
        hamburgerXEgg.setTomato(hamburgerXEgg.tomatoFactory());
        System.out.println(hamburgerXEgg);

        HamburgerFitness hamburgerFitness = new HamburgerFitness();
        hamburgerFitness.setBread(hamburgerFitness.breadFactory());
        hamburgerFitness.setCheese(hamburgerFitness.cheeseFactory());
        hamburgerFitness.setHam(hamburgerFitness.hamFactory());
        hamburgerFitness.setEgg(hamburgerFitness.eggFactory());
        hamburgerFitness.setTomato(hamburgerFitness.tomatoFactory());
        System.out.println(hamburgerFitness);
    }
}
