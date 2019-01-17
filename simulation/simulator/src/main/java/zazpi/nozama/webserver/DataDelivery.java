package zazpi.nozama.webserver;

public class DataDelivery {
    private int id;
    private String row;
    private int num;
    private boolean available;

    public DataDelivery(int id, String row, int num, boolean available) {
        this.id = id;
        this.row = row;
        this.num = num;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getRow() {
        return row;
    }

    public int getNum() {
        return num;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "DataDelivery{" +
                "id=" + id +
                ", row='" + row + '\'' +
                ", num=" + num +
                ", available=" + available +
                '}';
    }
}
