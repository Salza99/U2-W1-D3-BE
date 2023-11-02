package epicode.u5d1hw.entities.toppings;

import epicode.u5d1hw.entities.Food;

public class HamTopping extends ToppingDecorator{

    public HamTopping(){
        super();
        this.name = "Prosciutto";
        this.price = 2.00;
        this.calories = 200;
    }
    public HamTopping(Food p) {
        super(p);
        this.name = "Prosciutto";
        this.price = 2.00;
        this.calories = 200;
    }
}
