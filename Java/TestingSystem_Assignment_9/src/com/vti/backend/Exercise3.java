package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.Car;
import com.vti.entity.Car.Engine;

public class Exercise3 {
	public static void Question1() {
		CPU.Processor processor = new CPU.Processor(30f, "VietNam");
		System.out.println(processor.getCache());
		CPU.Ram ram = new CPU.Ram("4G", "VietNamese");
		System.out.println(ram.getClockSpeed());

	}
	public static void Question2() {
		Car car = new Car("Mazda",  "8WD");
		Engine engine = new Car.Engine("Crysler");
		System.out.println(engine.getEngineType());
		
	}
}
