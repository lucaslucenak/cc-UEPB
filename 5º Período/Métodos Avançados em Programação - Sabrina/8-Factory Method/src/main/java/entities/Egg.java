package entities;

import fillingsTypes.EggTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Egg {

    private EggTypeEnum eggTypeEnum;

    public Egg() {
    }

    public Egg(EggTypeEnum eggTypeEnum) {
        this.eggTypeEnum = eggTypeEnum;
    }
}
