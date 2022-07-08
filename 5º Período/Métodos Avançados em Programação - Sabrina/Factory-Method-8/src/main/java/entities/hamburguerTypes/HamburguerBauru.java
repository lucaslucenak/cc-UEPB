package entities.hamburguerTypes;

import entities.*;
import fillingsTypes.*;
import interfaces.HamburguerInterface;

public class HamburguerBauru extends Hamburguer implements HamburguerInterface {

    @Override
    public void setBreadType() {
        setBread(new Bread(BreadTypeEnum.Frances));
    }

    @Override
    public void setCheeseType() {
        setCheese(new Cheese(CheeseTypeEnum.Mussarela));
    }

    @Override
    public void setEggType() {
        setEgg(new Egg(EggTypeEnum.Granja));
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
