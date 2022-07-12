package entities;

import fillingsTypes.BreadTypeEnum;
import fillingsTypes.CheeseTypeEnum;
import fillingsTypes.EggTypeEnum;
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

    public Bread breadFactory() {
        return new Bread(BreadTypeEnum.Padrao);
//        bread.setBreadTypeEnum(BreadTypeEnum.Bola);
    }

    public Cheese cheeseFactory() {
//        cheese.setCheeseTypeEnum(CheeseTypeEnum.Mussarela);
        return new Cheese(CheeseTypeEnum.Padrao);
    }

    public Egg eggFactory() {
//        egg.setEggTypeEnum(EggTypeEnum.Granja);
        return new Egg(EggTypeEnum.Padrao);
    }

    public void setHamType() {
//        ham.setHamTypeEnum(HamTypeEnum.Frango);
    }

    public void addTomato() {
//        tomato.setTomatoTypeEnum(TomatoTypeEnum.TomateVermelho);
    }

//    @Override
//    public String toString() {
//        return "Hamburguer{" +
//                "bread=" + bread.getBreadTypeEnum() +
//                ", cheese=" + cheese.getCheeseTypeEnum() +
//                ", egg=" + egg.getEggTypeEnum() +
//                ", ham=" + ham.getHamTypeEnum() +
//                ", tomato=" + tomato.getTomatoTypeEnum() +
//                '}';
//    }

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
