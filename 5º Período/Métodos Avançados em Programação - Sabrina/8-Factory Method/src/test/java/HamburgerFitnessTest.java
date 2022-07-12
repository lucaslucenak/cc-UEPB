import entities.hamburguerTypes.HamburgerFitness;
import fillingsTypes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HamburgerFitnessTest {
    HamburgerFitness hamburgerFitness;

    @BeforeEach
    void setUp() {
        hamburgerFitness = new HamburgerFitness();
    }

    @Test
    public void shouldSetIntegralBreadType() {
        hamburgerFitness.setBread(hamburgerFitness.breadFactory());
        Assertions.assertEquals(BreadTypeEnum.Integral, hamburgerFitness.getBread().getBreadTypeEnum());
    }

    @Test
    public void shouldSetRicotaCheeseType() {
        hamburgerFitness.setCheese(hamburgerFitness.cheeseFactory());
        Assertions.assertEquals(CheeseTypeEnum.Ricota, hamburgerFitness.getCheese().getCheeseTypeEnum());
    }

    @Test
    public void shouldSetCapoeiraEggType() {
        hamburgerFitness.setEgg(hamburgerFitness.eggFactory());
        Assertions.assertEquals(EggTypeEnum.Capoeira, hamburgerFitness.getEgg().getEggTypeEnum());
    }

    @Test
    public void shouldSetPeruHamType() {
        hamburgerFitness.setHam(hamburgerFitness.hamFactory());
        Assertions.assertEquals(HamTypeEnum.Peru, hamburgerFitness.getHam().getHamTypeEnum());
    }

    @Test
    public void shouldAddTomato() {
        hamburgerFitness.setTomato(hamburgerFitness.tomatoFactory());
        Assertions.assertEquals(TomatoTypeEnum.TomateVermelho, hamburgerFitness.getTomato().getTomatoTypeEnum());
    }
}
