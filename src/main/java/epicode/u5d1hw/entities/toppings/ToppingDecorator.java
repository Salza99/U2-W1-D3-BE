package epicode.u5d1hw.entities.toppings;

import epicode.u5d1hw.entities.Food;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
public abstract class ToppingDecorator extends Food {
    protected Food decoratedPizza;

    @Override
    public String getName() {
        if(this.decoratedPizza != null)	return this.decoratedPizza.getName() + ", " + this.name;
        else return this.name;
    }

    @Override
    public double getPrice() {
        if(this.decoratedPizza != null) return this.decoratedPizza.getPrice() + this.price;
        else return this.price;
    }

    @Override
    public int getCalories() {
        if(this.decoratedPizza != null)	return this.decoratedPizza.getCalories() + this.calories;
        else return this.calories;
    }

    @Override
    public String toString() {
        return this.getName() + ", prezzo: " + this.getPrice() + "€ , calorie: " + this.getCalories();
    }
}
