package epicode.u5d1hw.entities.toppings;

import epicode.u5d1hw.entities.Food;
import lombok.NoArgsConstructor;

public class BufalaTopping extends ToppingDecorator{

    public BufalaTopping() {
        super();
        this.name = "Mozzarella di Bufala";
        this.price = 2.00;
        this.calories = 300;
    }
    public BufalaTopping(Food p) {
        super(p);
        this.name = "Mozzarella di Bufala";
        this.price = 2.00;
        this.calories = 300;
    }
}
