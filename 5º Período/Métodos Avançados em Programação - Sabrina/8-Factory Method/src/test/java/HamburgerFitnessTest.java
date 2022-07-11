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
        hamburgerFitness.setBreadType();
        Assertions.assertEquals(BreadTypeEnum.Integral, hamburgerFitness.getBread().getBreadTypeEnum());
    }

    @Test
    public void shouldSetRicotaCheeseType() {
        hamburgerFitness.setCheeseType();
        Assertions.assertEquals(CheeseTypeEnum.Ricota, hamburgerFitness.getCheese().getCheeseTypeEnum());
    }

    @Test
    public void shouldSetCapoeiraEggType() {
        hamburgerFitness.setEggType();
        Assertions.assertEquals(EggTypeEnum.Capoeira, hamburgerFitness.getEgg().getEggTypeEnum());
    }

    @Test
    public void shouldSetPeruHamType() {
        hamburgerFitness.setHamType();
        Assertions.assertEquals(HamTypeEnum.Peru, hamburgerFitness.getHam().getHamTypeEnum());
    }

    @Test
    public void shouldAddTomato() {
        hamburgerFitness.addTomato();
        Assertions.assertEquals(TomatoTypeEnum.TomateVermelho, hamburgerFitness.getTomato().getTomatoTypeEnum());
    }
}
