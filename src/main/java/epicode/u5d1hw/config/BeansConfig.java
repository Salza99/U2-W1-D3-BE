package epicode.u5d1hw.config;

import epicode.u5d1hw.entities.Food;
import epicode.u5d1hw.entities.Menu;
import epicode.u5d1hw.entities.drinks.Drink;
import epicode.u5d1hw.entities.drinks.Lemonade;
import epicode.u5d1hw.entities.pizzas.PizzaMargherita;
import epicode.u5d1hw.entities.tables.Table;
import epicode.u5d1hw.entities.toppings.BufalaTopping;
import epicode.u5d1hw.entities.toppings.HamTopping;
import epicode.u5d1hw.entities.toppings.ToppingDecorator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class BeansConfig {
    @Bean("margherita_normale")
    Food getMargherita(){
        return new PizzaMargherita("Margherita", false);
    }

    @Bean("margherita_xl")
    Food getMargheritaXL(){
        return new PizzaMargherita("Margherita XL", true);
    }

    @Bean("prosciutto_normale")
    Food getProsciutto(){
        return new HamTopping(new PizzaMargherita("Prosciutto", false));
    }

    @Bean("margherita_bufala_normale")
    Food getBufala(){
        return new BufalaTopping(new PizzaMargherita("Bufalina", false));
    }

    @Bean("margherita_bufala_crudo_normale")
    Food getBufalaCrudo(){
        return new HamTopping(new BufalaTopping(new PizzaMargherita("Bufala e Crudo", false)));
    }

    @Bean("Limonata")
    Drink getLemonade(){
        return new Lemonade();
    }

    @Bean("Prosciutto")
    ToppingDecorator getHamTopping(){ return new HamTopping();}

    @Bean("Bufala")
    ToppingDecorator getBufalaTopping(){ return new BufalaTopping();}


    @Bean("Tavolo1")
    Table getTable1( @Value("${seat.price}") double seatPrice){ return new Table(1, 5, true, seatPrice);}

    @Bean("Tavolo2")
    Table getTable2(@Value("${seat.price}") double seatPrice){ return new Table(2, 4, true, seatPrice);}

    @Bean("Tavolo3")
    Table getTable3(@Value("${seat.price}") double seatPrice){ return new Table(3, 8, true, seatPrice);}
}
