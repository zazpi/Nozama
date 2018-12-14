package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import demo.car.Car;
import demo.car.Cars;
import demo.car.ThreadCar;
import demo.order.Order;
import demo.order.Product;
import demo.order.ThreadOrder;
import demo.position.Parking;
import demo.position.Workstation;

public class MainDemo {
	public static final int N_WORKSTATIONS = 6;
	public static final int N_PARKING = 4;
	public static final int N_PRODUCTS = 30;
	public static final int N_ORDERS = 15;
	public static final int N_CARS = 5;
	public static final int N_SEGMENTS = 16;
	
	List<Workstation> workstations;
	List<Parking> parkings;
	
	List<Product> products;
	List<Order> orders;
	
	Car [] car;
	Cars cars;
	
	ThreadCar [] threadCar;
	ThreadWorker [] threadWorker;
	ThreadOrder threadOrder;
	Thread [] threads;
	
	public MainDemo () {
		threadCar = new ThreadCar[N_CARS];
		threadWorker = new ThreadWorker[N_WORKSTATIONS];
		threads = new Thread[N_CARS+N_WORKSTATIONS+1];
		
		workstations = new ArrayList<>();
		parkings = new ArrayList<>();
		products = new ArrayList<>();
		orders = new ArrayList<>();
		Random random = new Random();
		
		for (int i=0;i<N_WORKSTATIONS;i++) {
			workstations.add(new Workstation(i));
		}
		for (int i=0;i<N_PARKING;i++) {
			parkings.add(new Parking(i));
		}
		
		car = new Car[N_CARS];
		for (int i=0;i < N_CARS;i++) car[i] = new Car(i, workstations.get(i));		
		cars = new Cars(N_CARS, Arrays.asList(car));
		
		for (int j=0;j<N_PRODUCTS;j++) {
			products.add(new Product(j));
		}
		
		for (int k=0;k<N_ORDERS;k++) {
			List<Product> orderProducts = new ArrayList<>();
			for (int l=0;l<(random.nextInt(4)+1);l++) {
				orderProducts.add(products.get(random.nextInt(N_PRODUCTS)));
			}
			Workstation origin = workstations.get(random.nextInt(N_WORKSTATIONS));
			Workstation destination;
			do {
				destination = workstations.get(random.nextInt(N_WORKSTATIONS));
			} while (origin.getId() == destination.getId());
			orders.add(new Order(k, orderProducts, origin, destination));
		}
	}
	
	public void createThreads () {
		for (int i=0;i<N_CARS;i++) {
			threadCar[i] = new ThreadCar(i, workstations, parkings, car[i], cars);
			threads[i] = new Thread(threadCar[i], String.valueOf(i));
		}
		for (int i=0;i<N_WORKSTATIONS;i++) {
			threadWorker[i] = new ThreadWorker(i, workstations.get(i));
			threads[N_CARS+i] = new Thread(threadWorker[i], String.valueOf(i));
		}
		
		int last = N_CARS+N_WORKSTATIONS;
		threadOrder = new ThreadOrder(orders);
		threads[last] = new Thread(threadOrder, String.valueOf(last));
	}
	
	public void startThreads () {
		for (int i=0;i<(N_CARS+N_WORKSTATIONS+1);i++) {
			threads[i].start();
		}
	}
	
	public void killThreads () {
		for (int i=0;i<(N_CARS+N_WORKSTATIONS+1);i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main (String [] args) {
		MainDemo mainDemo = new MainDemo();
		
		mainDemo.createThreads();
		mainDemo.startThreads();
		mainDemo.killThreads();
		
		System.out.println("Everything was better than expected");
	}
}
