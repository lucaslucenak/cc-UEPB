package entities;

import fillingsTypes.*;
import interfaces.HamburguerInterface;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hamburguer {
//    List<Enum> fillings = new ArrayList<>();
    private Bread bread;
    private Cheese cheese;
    private Egg egg;
    private Ham ham;

    private Tomato tomato;

    public Hamburguer() {
        this.bread = new Bread(BreadTypeEnum.Bola);
        this.cheese = new Cheese(CheeseTypeEnum.Mussarela);
        this.egg = new Egg(EggTypeEnum.Granja);
        this.ham = new Ham(HamTypeEnum.Frango);
        this.tomato = new Tomato(TomatoTypeEnum.TomateVermelho);
    }

//    public void setBreadType() {
//        bread.setBreadTypeEnum(BreadTypeEnum.Bola);
//    }
//
//    public void setCheeseType() {
//        cheese.setCheeseTypeEnum(CheeseTypeEnum.Mussarela);
//    }
//
//    public void setEggType() {
//        egg.setEggTypeEnum(EggTypeEnum.Granja);
//    }
//
//    public void setHamType() {
//        ham.setHamTypeEnum(HamTypeEnum.Frango);
//    }
//
//    public void addTomato() {
//        tomato.setTomatoTypeEnum(TomatoTypeEnum.TomateVermelho);
//    }
//
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
