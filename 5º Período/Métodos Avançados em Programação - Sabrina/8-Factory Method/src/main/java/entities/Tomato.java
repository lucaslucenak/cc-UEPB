package entities;

import fillingsTypes.TomatoTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tomato {

    private TomatoTypeEnum tomatoTypeEnum;

    public Tomato() {

    }

    public Tomato(TomatoTypeEnum tomatoTypeEnum) {
        this.tomatoTypeEnum = tomatoTypeEnum;
    }
}
