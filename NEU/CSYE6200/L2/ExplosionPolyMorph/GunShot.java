package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class GunShot extends Explosion {
	public GunShot() {
		super();
	}

	@Override
	public void explode() {
		System.out.println("POW");
	}

	public static void demo() {
		Explosion explosion = new Explosion(); // explosion object
		GunShot gunShot = new GunShot(); // GunShot object

		System.out.println("My object inherited this from Object class ->" + gunShot.getClass().getName());
		System.out.println("My class inherited this from Object class ->" + GunShot.class.getName());

		System.out.println("Demonstrate Polymorphism (hide derived classes)");
		List<AbstractExplosionAPI> explosions = new ArrayList<>(); // container
		explosions.add(explosion); // add Explosion obj to container
		explosions.add(gunShot); // add GunShot obj to container
		System.out.println(explosions.size() + " explosion objects");
		for (AbstractExplosionAPI obj : explosions) {
			obj.explode(); // explode object
		}
	}

}
