package weekend.cinema;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie extends AbstractEntity {

    @Column(nullable=false, unique=true)
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String time;
    private Integer year;

    public Movie() {
    }

    public Movie(String title, Genre genre, String time, Integer year) {
        this.title = title;
        this.genre = genre;
        this.time = time;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre=" + genre +
                ", time='" + time + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
