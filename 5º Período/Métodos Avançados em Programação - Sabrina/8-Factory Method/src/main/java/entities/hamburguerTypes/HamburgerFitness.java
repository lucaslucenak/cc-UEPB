package entities.hamburguerTypes;

import entities.*;
import fillingsTypes.*;

public class HamburgerFitness extends Hamburguer{

    @Override
    public Bread breadFactory() {
//        setBread(new Bread(BreadTypeEnum.Integral));
        return new Bread(BreadTypeEnum.Integral);
    }

    @Override
    public Cheese cheeseFactory() {
//        setCheese(new Cheese(CheeseTypeEnum.Ricota));
        return new Cheese(CheeseTypeEnum.Ricota);
    }

    @Override
    public Egg eggFactory() {
//        setEgg(new Egg(EggTypeEnum.Capoeira));
        return new Egg(EggTypeEnum.Capoeira);
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
