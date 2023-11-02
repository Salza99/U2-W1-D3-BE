package epicode.u5d1hw;

import epicode.u5d1hw.entities.Food;
import epicode.u5d1hw.entities.orders.Order;
import epicode.u5d1hw.entities.pizzas.Pizza;
import epicode.u5d1hw.entities.pizzas.PizzaMargherita;
import epicode.u5d1hw.entities.tables.Table;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class OrderTest {
    static AnnotationConfigApplicationContext context;
    static Order ordertest;
    static Order orderOnOccupiedTable;
    static Table occupiedTableTest;
    static Pizza foodTest;
    @BeforeAll
    static void beforeAll() {
        context = new AnnotationConfigApplicationContext(U5d1hwApplication.class);

        occupiedTableTest = context.getBean("Tavolo1", Table.class);
        foodTest = context.getBean("margherita_normale",PizzaMargherita.class);
        ordertest = new Order(occupiedTableTest, 5);

    }
    @AfterAll
    static void afterAll() {
        context.close();
    }
    @Test
    public void addItemTest() {
        ordertest.addItem(foodTest);
    }
    @Test
    public void throwExceptionIfTableOccupiedTest() {

        assertThrows(RuntimeException.class, () -> {
            orderOnOccupiedTable = new Order(occupiedTableTest, 5);
        });
    }

}
