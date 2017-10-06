package weekend.cinema;

import weekend.adverts.AbstractDao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Room extends AbstractEntity{

    @Column(nullable=false)
    private int rows;

    @Column(nullable=false)
    private int seatsInRow;

    @Column(nullable=false, unique=true)
    private String description;

    public Room() {
    }

    public Room(int rows, int seatsInRow, String description) {
        this.rows = rows;
        this.seatsInRow = seatsInRow;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeatsInRow() {
        return seatsInRow;
    }

    public void setSeatsInRow(int seatsInRow) {
        this.seatsInRow = seatsInRow;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rows=" + rows +
                ", seatsInRow=" + seatsInRow +
                ", description='" + description + '\'' +
                '}';
    }
}
