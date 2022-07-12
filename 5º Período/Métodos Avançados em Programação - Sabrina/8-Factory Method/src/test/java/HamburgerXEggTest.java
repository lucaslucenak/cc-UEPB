import entities.hamburguerTypes.HamburgerXEgg;
import fillingsTypes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HamburgerXEggTest {
    HamburgerXEgg hamburgerXEgg;

    @BeforeEach
    void setUp() {
        hamburgerXEgg = new HamburgerXEgg();
    }

    @Test
    public void shouldSetBolaBreadType() {
        hamburgerXEgg.breadFactory();
        Assertions.assertEquals(BreadTypeEnum.Bola, hamburgerXEgg.getBread().getBreadTypeEnum());
    }

    @Test
    public void shouldSetCheddarCheeseType() {
        hamburgerXEgg.cheeseFactory();
        Assertions.assertEquals(CheeseTypeEnum.Cheddar, hamburgerXEgg.getCheese().getCheeseTypeEnum());
    }

    @Test
    public void shouldSetCapoeiraEggType() {
        hamburgerXEgg.eggFactory();
        Assertions.assertEquals(EggTypeEnum.Capoeira, hamburgerXEgg.getEgg().getEggTypeEnum());
    }

    @Test
    public void shouldSetPeruHamType() {
        hamburgerXEgg.setHamType();
        Assertions.assertEquals(HamTypeEnum.Peru, hamburgerXEgg.getHam().getHamTypeEnum());
    }

    @Test
    public void shouldAddTomato() {
        hamburgerXEgg.addTomato();
        Assertions.assertEquals(TomatoTypeEnum.TomateVermelho, hamburgerXEgg.getTomato().getTomatoTypeEnum());
    }
}
