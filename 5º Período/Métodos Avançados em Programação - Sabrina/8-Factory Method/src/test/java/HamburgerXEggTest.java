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
        hamburgerXEgg.setBread(hamburgerXEgg.breadFactory());
        Assertions.assertEquals(BreadTypeEnum.Bola, hamburgerXEgg.getBread().getBreadTypeEnum());
    }

    @Test
    public void shouldSetCheddarCheeseType() {
        hamburgerXEgg.setCheese(hamburgerXEgg.cheeseFactory());
        Assertions.assertEquals(CheeseTypeEnum.Cheddar, hamburgerXEgg.getCheese().getCheeseTypeEnum());
    }

    @Test
    public void shouldSetCapoeiraEggType() {
        hamburgerXEgg.setEgg(hamburgerXEgg.eggFactory());
        Assertions.assertEquals(EggTypeEnum.Capoeira, hamburgerXEgg.getEgg().getEggTypeEnum());
    }

    @Test
    public void shouldSetPeruHamType() {
        hamburgerXEgg.setHam(hamburgerXEgg.hamFactory());
        Assertions.assertEquals(HamTypeEnum.Peru, hamburgerXEgg.getHam().getHamTypeEnum());
    }

    @Test
    public void shouldAddTomato() {
        hamburgerXEgg.setTomato(hamburgerXEgg.tomatoFactory());
        Assertions.assertEquals(TomatoTypeEnum.TomateVermelho, hamburgerXEgg.getTomato().getTomatoTypeEnum());
    }
}
