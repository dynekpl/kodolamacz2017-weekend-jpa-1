package weekend;

import javax.persistence.*;
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

    private String model;

    private int resolution;
    private String proccessor;
    private int ram;

    @Temporal(TemporalType.DATE)
    private Date prodDate;

    public Notebook(String model, int resolution) {
        this.model = model;
        this.resolution = resolution;
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

    public Date getProdDate() {
        return prodDate;
    }

    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }
}
