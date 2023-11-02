package epicode.u5d1hw.entities.pizzas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class PizzaMargherita extends Pizza {
    public PizzaMargherita(String name, boolean xl) {
        super(name, xl);
    }

    @Override
    public String toString() {
        return this.name + ", prezzo: " + this.getPrice() + "€ , calorie: " + this.getCalories();
    }
}
