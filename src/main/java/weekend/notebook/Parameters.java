package weekend.notebook;

public class Parameters {

    private int resolution;
    private String proccessor;
    private int ram;

    public Parameters(int resolution, String proccessor, int ram) {
        this.resolution = resolution;
        this.proccessor = proccessor;
        this.ram = ram;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public String getProccessor() {
        return proccessor;
    }

    public void setProccessor(String proccessor) {
        this.proccessor = proccessor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "resolution=" + resolution +
                ", proccessor='" + proccessor + '\'' +
                ", ram=" + ram +
                '}';
    }
}
