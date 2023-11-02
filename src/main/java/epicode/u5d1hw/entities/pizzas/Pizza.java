package epicode.u5d1hw.entities.pizzas;

import epicode.u5d1hw.entities.Food;
import lombok.Getter;

@Getter
public abstract class Pizza extends Food {
    boolean xl = false;

    public Pizza(String name, boolean xl) {
        this.name = name;
        this.xl = xl;
        this.calories = 700;
        this.price = xl ? 7.00 : 5.00;
    }

    @Override
    public String toString() {
        return this.name + ", prezzo: " + this.getPrice() + "€ , calorie: " + this.getCalories();
    }
}
