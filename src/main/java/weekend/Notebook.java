package weekend;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "notebooks")
@NamedQueries({
        @NamedQuery(name = "Notebook.findAll", query = "select n from Notebook n"),
        @NamedQuery(name = "Notebook.findById", query = "select n from Notebook n where n.id = :ID"),
        @NamedQuery(name = "Notebook.getParameters", query = "select new weekend.notebook.Parameters(n.resolution, n.proccessor, n.ram) from Notebook n")
})
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(max = 10)
    @NotNull
    private String model;

    private int resolution;

    @Size(min = 4, message = "Przy użyciu mniej niż 4 znaków nie da się precyzyjnie określić procesora")
    private String proccessor;
    private int ram;

    @Future
    @Temporal(TemporalType.DATE)
    private Date warrantyDate;

    public Notebook(String model, int resolution) {
        this.model = model;
        this.resolution = resolution;
    }

    public Notebook(String model) {
        this(model, 0);
    }

    public Notebook() {
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "model='" + model + '\'' +
                ", resolution=" + resolution +
                '}';
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public Date getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(Date warrantyDate) {
        this.warrantyDate = warrantyDate;
    }
}
