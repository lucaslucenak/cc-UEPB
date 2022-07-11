package entities;

import fillingsTypes.BreadTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bread {
    private BreadTypeEnum breadTypeEnum;

    public Bread() {
    }

    public Bread(BreadTypeEnum breadTypeEnum) {
        this.breadTypeEnum = breadTypeEnum;
    }
}
