package entities;

import fillingsTypes.CheeseTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cheese {

    private CheeseTypeEnum cheeseTypeEnum;

    public Cheese() {
    }

    public Cheese(CheeseTypeEnum cheeseTypeEnum) {
        this.cheeseTypeEnum = cheeseTypeEnum;
    }
}
