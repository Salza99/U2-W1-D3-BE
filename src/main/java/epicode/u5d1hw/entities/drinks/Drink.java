package epicode.u5d1hw.entities.drinks;

import epicode.u5d1hw.entities.Food;

public abstract class Drink extends Food {
    @Override
    public String toString() {
        return this.name + ", prezzo: " + this.getPrice() + "€, calorie: " + this.getCalories();
    }
}
