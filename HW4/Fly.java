import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

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
            return "I'm dead, but I used to be a fly with a speed of " + String.format("%.2f", speed);
        } else {
            return "I'm a speedy fly with " + String.format("%.2f", speed) + " speed and " + String.format("%.2f", mass) + " mass.";
        }
    }

    //grow - takes in an integer parameter representing the added mass.
    // Then it increases the mass of the Fly by the given number of mass. As mass increases, speed changes as follows:
    //If mass is less than 20: increases speed by 1 for every mass the Fly grows until it reaches 20 mass.
    //If the mass is 20 or more: decreases speed by 0.5 for each mass unit added over 20.
    // Fly had initial mass 10.0 and initial speed 50.0.
    // It was grown by 45 mass units and did not have proper final speed.
    //expected:<42.5> but was:<27.5>
    //Fly had initial mass 20.0 and initial speed 1.0.
    // It was grown by 0 mass units and did not have proper final speed.
    // expected:<1.0> but was:<21.0>
    //Fly had initial mass 21.0 and initial speed 1.0. It was grown by 0 mass units and did not have proper final speed.
    //expected:<1.0> but was:<21.5>
    //Fly had initial mass 20.0 and initial speed 10.0. It was grown by 20 mass units and did not have proper final speed.
    // expected:<0.0> but was:<10.0>
    //Fly had initial mass 30.0 and initial speed 50.0. It was grown by 10 mass units and did not have proper final speed.
    //expected:<45.0> but was:<50.0>
    public void grow(int addedMass) {
        double initialMass = mass;
        mass += addedMass;
        if (mass <= 20) {
            while (mass <= 20 && addedMass > 0 && speed >= 0) {
                speed++;
                addedMass--;
            }
        } else if (initialMass >= 20 && speed >= 0) {
            while (speed > 0 && addedMass > 0) {
                speed = speed - 0.5;
                addedMass--;
            }
        } else if (mass >= 20 && initialMass < 20 && speed > 0) {
            speed = speed - 0.5 * (addedMass-initialMass-20);
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
