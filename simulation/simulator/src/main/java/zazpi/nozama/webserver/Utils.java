package zazpi.nozama.webserver;

import java.util.ArrayList;
import java.util.List;

import zazpi.nozama.simulation.Car;

public class Utils {
	
	private Utils () {}

    public static List<DataDelivery> getCarsPositions(List<Car> cars) {
        List<DataDelivery> dataDeliveries = new ArrayList<>();
        for (Car c: cars) {
            int id = c.getId();
            String row = c.getCurrentPos().getRow();
            int num = c.getCurrentPos().getNum();
            boolean available = c.getCurrentPos().available();
            DataDelivery dataDelivery = new DataDelivery(id,row,num,available);
            dataDeliveries.add(dataDelivery);
        }
        return dataDeliveries;
    }
}
