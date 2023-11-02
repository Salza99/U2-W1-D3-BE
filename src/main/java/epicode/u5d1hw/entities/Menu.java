package epicode.u5d1hw.entities;

import epicode.u5d1hw.entities.drinks.Drink;
import epicode.u5d1hw.entities.toppings.ToppingDecorator;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component("menu")
public class Menu {
    private List<Food> menuPizza = new ArrayList<>();
    private List<ToppingDecorator> menuTopping = new ArrayList<>();
    private List<Drink> menuDrink = new ArrayList<>();

    @Autowired
    public Menu(List<Food> menuPizza, List<ToppingDecorator> menuTopping, List<Drink> menuDrink) {
        this.menuPizza = menuPizza;
        this.menuTopping = menuTopping;
        this.menuDrink = menuDrink;
    }

    public void printMenu() {
        System.out.println("******* Menu *******");
        System.out.println("PIZZAS");
        this.menuPizza.forEach(System.out::println);
        System.out.println();

        System.out.println("TOPPINGS");
        this.menuTopping.forEach(System.out::println);
        System.out.println();

        System.out.println("DRINKS");
        this.menuDrink.forEach(System.out::println);
        System.out.println();

    }
}
