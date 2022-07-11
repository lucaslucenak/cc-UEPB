package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class Hamburguer {

    private Bread bread;
    private Cheese cheese;
    private Egg egg;
    private Ham ham;
    private Tomato tomato;

    public void setBreadType() {
//        bread.setBreadTypeEnum(BreadTypeEnum.Bola);
    }

    public void setCheeseType() {
//        cheese.setCheeseTypeEnum(CheeseTypeEnum.Mussarela);
    }

    public void setEggType() {
//        egg.setEggTypeEnum(EggTypeEnum.Granja);
    }

    public void setHamType() {
//        ham.setHamTypeEnum(HamTypeEnum.Frango);
    }

    public void addTomato() {
//        tomato.setTomatoTypeEnum(TomatoTypeEnum.TomateVermelho);
    }

    @Override
    public String toString() {
        return "Hamburguer{" +
                "bread=" + bread.getBreadTypeEnum() +
                ", cheese=" + cheese.getCheeseTypeEnum() +
                ", egg=" + egg.getEggTypeEnum() +
                ", ham=" + ham.getHamTypeEnum() +
                ", tomato=" + tomato.getTomatoTypeEnum() +
                '}';
    }
}
