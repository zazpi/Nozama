package zazpi.nozama.webserver;

import zazpi.nozama.simulation.Car;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	private Utils () {}

    public static List<Object []> getCarsPositions(List<Car> cars) {
        List<Object []> objects = new ArrayList<>();
        for (Car c: cars) {
            String row = c.getCurrentPos().getRow();
            int num = c.getCurrentPos().getNum();
            boolean available = c.getCurrentPos().available();
            Object [] values = {row,num,available};
            objects.add(values);
        }
        return objects;
    }
}
