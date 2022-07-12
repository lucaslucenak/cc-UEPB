import entities.hamburguerTypes.HamburgerBauru;
import fillingsTypes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HamburgerBauruTest {
    HamburgerBauru hamburgerBauru;

    @BeforeEach
    void setUp() {
        hamburgerBauru = new HamburgerBauru();
    }

    @Test
    public void shouldSetFrancesBreadType() {
        hamburgerBauru.setBread(hamburgerBauru.breadFactory());
        Assertions.assertEquals(BreadTypeEnum.Frances, hamburgerBauru.getBread().getBreadTypeEnum());
    }

    @Test
    public void shouldSetMussarelaCheeseType() {
        hamburgerBauru.setCheese(hamburgerBauru.cheeseFactory());
        Assertions.assertEquals(CheeseTypeEnum.Mussarela, hamburgerBauru.getCheese().getCheeseTypeEnum());
    }

    @Test
    public void shouldSetGranjaEggType() {
        hamburgerBauru.setEgg(hamburgerBauru.eggFactory());
        Assertions.assertEquals(EggTypeEnum.Granja, hamburgerBauru.getEgg().getEggTypeEnum());
    }

    @Test
    public void shouldSetPeruHamType() {
        hamburgerBauru.setHam(hamburgerBauru.hamFactory());
        Assertions.assertEquals(HamTypeEnum.Peru, hamburgerBauru.getHam().getHamTypeEnum());
    }

    @Test
    public void shouldAddTomato() {
        hamburgerBauru.setTomato(hamburgerBauru.tomatoFactory());
        Assertions.assertEquals(TomatoTypeEnum.TomateVermelho, hamburgerBauru.getTomato().getTomatoTypeEnum());
    }
}
