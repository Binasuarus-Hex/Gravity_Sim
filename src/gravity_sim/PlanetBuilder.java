package gravity_sim;

import java.awt.Color;
import java.util.Random;

public class PlanetBuilder {
	
	public Color colour = Color.BLACK;
	public double mass = 0;
	public double radius = 0;
	public double x = 0;
	public double y = 0; 
	public double Vx = 0;
	public double Vy = 0;
	public boolean canMove = true;
	public boolean isFilled = false;
	
	public PlanetBuilder withColor(Color c) {
		this.colour = c;
		return this;
	}
	
	public PlanetBuilder withColour(Color c) {
		this.colour = c;
		return this;
	}
	
	public PlanetBuilder withRandomColour() {
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		this.colour = new Color(r, g, b);
		return this;
	}
	
	public PlanetBuilder withMass(double m) {
		this.mass = m;
		return this;
	}
	
	public PlanetBuilder withRadius(double r) {
		this.radius = r;
		return this;
	}
	
	public PlanetBuilder withRawLocation(double x, double y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	
	public PlanetBuilder withScaledLocation(double x, double y) {
		this.x = PlanetPhysics.scaleToReal(x);
		this.y = PlanetPhysics.scaleToReal(y);
		return this;
	}
	
	public PlanetBuilder withRawVelocity(double Vx, double Vy) {
		this.Vx = Vx;
		this.Vy = Vy;
		return this;
	}
	
	public PlanetBuilder withScaledVelocity(double Vx, double Vy) {
		this.Vx = PlanetPhysics.scaleToReal(Vx);
		this.Vy = PlanetPhysics.scaleToReal(Vy);
		return this;
	}
	
	public PlanetBuilder withMovement(boolean m) {
		this.canMove = m;
		return this;
	}
	
	public PlanetBuilder withFill(boolean f) {
		this.isFilled = f;
		return this;
	}
	
	public Planet build() {
		Planet p = new Planet(
				this.mass,
				this.radius,
				this.x,
				this.y,
				this.Vx,
				this.Vy
				);
		p.setMovement(this.canMove);
		p.setColour(this.colour);
		p.setFilled(this.isFilled);
		return p;
	}
}
