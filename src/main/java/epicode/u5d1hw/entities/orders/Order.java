package epicode.u5d1hw.entities.orders;

import epicode.u5d1hw.entities.Food;
import epicode.u5d1hw.entities.tables.Table;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Order {
    private int orderNumber;
    private OrderState state;
    private LocalDateTime dateTime;
    private List<Food> items;
    private Table tableRef;

    private int customers;

    public Order(Table tableRef, int customersNumber) {
        if(tableRef.isFree()) {
            tableRef.setFree(false);
            if(customersNumber <= tableRef.getSeats())  this.customers = customersNumber;
            else throw new RuntimeException("Non ci si può sedere in più di " + tableRef.getSeats());
            Random rndm = new Random();
            this.orderNumber = rndm.nextInt(1, 10000);
            this.state = OrderState.INCORSO;
            this.dateTime = LocalDateTime.now();
            this.items = new ArrayList<>();
            this.tableRef = tableRef;
        } else {
            throw new RuntimeException("Il tavolo è occupato!");
        }
    }

    public void addItem(Food food){
        this.items.add(food);
    }

    public double getTotal(){
        double costoPietanze = this.items.stream().mapToDouble(Food::getPrice).sum();
        double costoCoperti = this.customers * this.tableRef.getSeatPrice();
        return costoCoperti + costoPietanze;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", state=" + state +
                ", dateTime=" + dateTime +
                ", tableRef=" + tableRef +
                ", customers=" + customers +
                '}';
    }
}
