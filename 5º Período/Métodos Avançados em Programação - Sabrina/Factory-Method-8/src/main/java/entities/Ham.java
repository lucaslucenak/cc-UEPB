package entities;


import fillingsTypes.HamTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ham {

    private HamTypeEnum hamTypeEnum;

    public Ham() {

    }

    public Ham(HamTypeEnum hamTypeEnum) {
        this.hamTypeEnum = hamTypeEnum;
    }
}
