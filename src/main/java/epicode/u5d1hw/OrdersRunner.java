package epicode.u5d1hw;

import epicode.u5d1hw.entities.Food;
import epicode.u5d1hw.entities.orders.Order;
import epicode.u5d1hw.entities.pizzas.Pizza;
import epicode.u5d1hw.entities.tables.Table;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class OrdersRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5d1hwApplication.class);
        try {
            Table t1 = (Table) ctx.getBean("Tavolo1");

            Order o1 = new Order(t1, 4);

            o1.addItem((Food) ctx.getBean("margherita_bufala_normale"));
            o1.addItem((Food)ctx.getBean("margherita_bufala_crudo_normale"));
            o1.addItem((Food)ctx.getBean("margherita_xl"));
            o1.addItem((Food)ctx.getBean("Limonata"));
            o1.addItem((Food)ctx.getBean("Limonata"));
            o1.addItem((Food)ctx.getBean("Limonata"));

            System.out.println("DETTAGLI TAVOLO 1:");
            System.out.println(o1);

            System.out.println("IL TAVOLO 1 HA ORDINATO: ");
            o1.getItems().forEach(System.out::println);

            System.out.println("AL TAVOLO 1 C'ERANO " + o1.getCustomers() + " CLIENTI");

            System.out.println("COSTO TOTALE TAVOLO 1");
            System.out.println(o1.getTotal());


        } catch (Exception e){
            System.err.println(e);

        }finally {
            ctx.close();
        }


    }
}
