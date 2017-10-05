package weekend.adverts;

import javax.persistence.*;

//Jeśli ustaimy parametr name w adnotacji Entity to spowoduje zmianę nazwę tabeli
//ale róznież co ważniejsze wszystkie zapytania JPQL muszą używać tą nową nazwę encji
// select a from avderts
//zamiast
// select a from Advert
//Jeśli chcemy wyłącznie zmienić nazwę tabeli to używamy name w adnotacji Table
@Entity
@Table(name = "adverts")
public class Advert extends AbstractEntity {

    private String title;

    @Column(name = "description")
    private String text;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // jeśli tego nie podamy to będzie wstawiać do bazy wartości enuma w formacie int
    //i wtedy jeśli dopiszemy w środku nową wartość to przy wyciąganiu danych ogłoszenia bedą przypisane do złej
    //kategorii
    private Category category;

    private Integer price;

    @ManyToOne
    private User owner;

    // my nie używamy tego konstruktora, ale hibernate tak - dlatego musi tutaj być
    public Advert() {
    }

    public Advert(String title, String text, int price) {
        this(title, text, price, Category.OTHERS);
    }

    public Advert(String title, String text, Integer price, Category category) {
        this.title = title;
        this.text = text;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Advert{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", owner=" + owner +
                '}';
    }
}
