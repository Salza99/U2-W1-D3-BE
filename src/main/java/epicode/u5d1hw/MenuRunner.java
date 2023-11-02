package epicode.u5d1hw;

import epicode.u5d1hw.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuRunner implements CommandLineRunner {
    @Autowired
    Menu menu;
    @Override
    public void run(String... args) throws Exception {
        menu.printMenu();
    }
}
