import java.util.*;

public class Fly {
    private double mass;
    private double speed;

    public static final double default_speed = 10;
    public static final double default_mass = 5;

    // Constructors
    public Fly() {
        this(default_mass, default_speed);
    }

    public Fly(double initMass) {
        this(initMass, default_speed);
    }

    public Fly(double initMass, double initSpeed) {
        this.mass = initMass;
        this.speed = initSpeed;
    }

    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String toString() {
        if (mass == 0) {
            return "I'm dead, but I used to be a fly with a speed of " + speed;
        } else {
            return "I'm a speedy fly with " + speed + " speed and " + mass + "mass.";
        }
    }

    public void grow(int addedMass) {
        mass += addedMass;
        if (mass < 20) {
            speed += mass;
        } else {
            speed = speed - 0.5 * (mass - 20);
        }
    }

    public boolean isDead() {
        if (mass == 0) {
            return true;
        } else {
            return false;
        }
    }
}
