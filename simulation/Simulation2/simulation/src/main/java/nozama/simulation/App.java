package nozama.simulation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Controller cont = new Controller();
        cont.createPositions();
        cont.createCars();
    }
}
