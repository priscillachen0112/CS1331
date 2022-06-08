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
    // Fly had initial mass 10.0 and initial speed 50.0.
    // It was grown by 45 mass units and did not have proper final speed.
    //expected:<42.5> but was:<27.5>
    public void grow(int addedMass) {
        mass += addedMass;
        if (mass < 20) {
            speed += addedMass;
        } else {
            speed = speed - 0.5 * (addedMass);
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
