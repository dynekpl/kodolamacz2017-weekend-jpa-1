package weekend.cinema;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Screening extends AbstractEntity{

    private String hour;

    @OneToOne
    private Movie movie;

    @OneToOne
    private Room room;

    public Screening() {
    }

    @Override
    public String toString() {
        return "Screening{" +
                "hour='" + hour + '\'' +
                ", movie=" + movie +
                ", room=" + room +
                '}';
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
