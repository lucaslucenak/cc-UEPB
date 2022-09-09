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
    public Ham hamFactory() {
//        setHam(new Ham(HamTypeEnum.Peru));
        return new Ham(HamTypeEnum.Peru);
    }

    @Override
    public Tomato tomatoFactory() {
//        setTomato(new Tomato(TomatoTypeEnum.TomateVermelho));
        return new Tomato(TomatoTypeEnum.TomateVermelho);
    }
}
