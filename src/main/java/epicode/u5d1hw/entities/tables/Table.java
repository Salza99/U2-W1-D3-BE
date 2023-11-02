package epicode.u5d1hw.entities.tables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@AllArgsConstructor
@ToString
@Getter
public class Table {
    long id;
    int seats;
    boolean free;
    double seatPrice;

    public Table(int id, int seats, boolean free, double seatPrice) {
        this.id = id;
        this.seats = seats;
        this.free = free;
        this.seatPrice = seatPrice;

    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
