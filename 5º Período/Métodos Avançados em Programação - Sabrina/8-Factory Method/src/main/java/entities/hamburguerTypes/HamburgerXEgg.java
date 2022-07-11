package entities.hamburguerTypes;

import entities.*;
import fillingsTypes.*;

public class HamburgerXEgg extends Hamburguer {

    @Override
    public void setBreadType() {
        setBread(new Bread(BreadTypeEnum.Bola));
    }

    @Override
    public void setCheeseType() {
        setCheese(new Cheese(CheeseTypeEnum.Cheddar));
    }

    @Override
    public void setEggType() {
        setEgg(new Egg(EggTypeEnum.Capoeira));
    }

    @Override
    public void setHamType() {
        setHam(new Ham(HamTypeEnum.Peru));
    }

    @Override
    public void addTomato() {
        setTomato(new Tomato(TomatoTypeEnum.TomateVermelho));
    }
}
