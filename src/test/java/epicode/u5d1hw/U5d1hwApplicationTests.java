package epicode.u5d1hw;

import epicode.u5d1hw.entities.pizzas.Pizza;
import epicode.u5d1hw.entities.pizzas.PizzaMargherita;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

@SpringBootTest
class U5d1hwApplicationTests {
    private static AnnotationConfigApplicationContext context;
    static Pizza testMargheritaPizza;
    static Pizza testMargheritaXlPizza;

    @BeforeAll
    static void beforeAll(){
        context = new AnnotationConfigApplicationContext((U5d1hwApplication.class));
        testMargheritaPizza = context.getBean("margherita_normale",PizzaMargherita.class);
        testMargheritaXlPizza = context.getBean("margherita_xl", PizzaMargherita.class );
    }
    @Test
    public void testNotNull() {
        assertNotNull(testMargheritaPizza);
    }
    @Test
    public void testNotSame() {
        assertNotSame(testMargheritaPizza, testMargheritaXlPizza);
    }
    @AfterAll
    static void afterAll() {
        context.close();
    }

}
