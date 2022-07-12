package entities.hamburguerTypes;

import entities.*;
import fillingsTypes.*;

public class HamburgerXEgg extends Hamburguer {

    @Override
    public Bread breadFactory() {
//        setBread(new Bread(BreadTypeEnum.Bola));
        return new Bread(BreadTypeEnum.Bola);
    }

    @Override
    public Cheese cheeseFactory() {
//        setCheese(new Cheese(CheeseTypeEnum.Cheddar));
        return new Cheese(CheeseTypeEnum.Cheddar);
    }

    @Override
    public Egg eggFactory() {
//        setEgg(new Egg(EggTypeEnum.Capoeira));
        return new Egg(EggTypeEnum.Capoeira);
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
