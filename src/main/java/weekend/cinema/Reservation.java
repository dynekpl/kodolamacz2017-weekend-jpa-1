package weekend.cinema;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation extends AbstractEntity{

    @OneToOne
    private Screening screening;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private User user;

    public Reservation() {
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "screening=" + screening +
                ", status=" + status +
                ", user=" + user +
                '}';
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
