package entities.hamburguerTypes;

import entities.*;
import fillingsTypes.*;

public class HamburgerBauru extends Hamburguer {

    public HamburgerBauru() {
    }

    @Override
    public Bread breadFactory() {
        return new Bread(BreadTypeEnum.Frances);
//        setBread(new Bread(BreadTypeEnum.Frances));
    }

    @Override
    public Cheese cheeseFactory() {
//        setCheese(new Cheese(CheeseTypeEnum.Mussarela));
        return new Cheese(CheeseTypeEnum.Mussarela);
    }

    @Override
    public Egg eggFactory() {
        setEgg(new Egg(EggTypeEnum.Granja));
        return new Egg(EggTypeEnum.Granja);
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
