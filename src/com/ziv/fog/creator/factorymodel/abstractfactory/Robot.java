package com.ziv.fog.creator.factorymodel.abstractfactory;

interface Engine{
	void run();
	void start();
}
class LuxuryEngine implements Engine{

	@Override
	public void run() {
		System.out.println("RUN -> LuxuryEngine");
	}

	@Override
	public void start() {
		System.out.println("START -> LuxuryEngine");
	}
	
}


interface Seat{
	void massage();
}
class LuxurySeat implements Seat{

	@Override
	public void massage() {
		System.out.println("MASSAGE -> LuxurySeat");
	}

}

interface Type{
	void revolve();
}
class LuxuryType implements Type{

	@Override
	public void revolve() {
		System.out.println("revolve -> LuxuryType");
	}

}

interface LowCarFactory{
	Engine createEngine();
	Seat createSeat();
	Type createType();
}

class LuxuryCarFactory implements LowCarFactory{

	@Override
	public Engine createEngine() {
		return new LuxuryEngine();
	}

	@Override
	public Seat createSeat() {
		return new LuxurySeat();
	}

	@Override
	public Type createType() {
		return new LuxuryType();
	}
	
}

public class Robot {
	public static void main(String[] args) {
		
	}
}
