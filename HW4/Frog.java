public class Frog {
    // Instance variables
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";

    public static final int default_age = 5;
    public static final double default_speed = 5;

    // Constructors
    public Frog(String initName) {
        this(initName, default_age, default_speed);
        this.isFroglet(age);
    }

    public Frog(String initName, double ageInYears) {
        this(initName, (int) ageInYears * 12, default_speed);
        this.isFroglet(age);
    }

    public Frog(String initName, int initAge, double initSpeed) {
        this.name = initName;
        this.age = initAge;
        this.tongueSpeed = initSpeed;
        this.isFroglet(age);
    }

    private void isFroglet(int age) {
        if (age>=1 && age <=7) {
            isFroglet = true;
        } else {
            isFroglet = false;
        }
    }

    public void grow(int months) {
        age = age + months;
        if (age <= 12) {
            tongueSpeed = tongueSpeed + months;
        } else if (age >= 30 && (tongueSpeed-months) >= 5) {
            tongueSpeed = tongueSpeed - months;
        }
        this.isFroglet(age);
    }

    public void grow() {
        age++;
        if (age <= 12) {
            tongueSpeed = tongueSpeed + 1;
        } else if (age >= 30 && (tongueSpeed-1) >= 5) {
            tongueSpeed = tongueSpeed - 1;
        }
        this.isFroglet(age);
    }

    public void eat(Fly fly) {
        if (fly.isDead()) {
            return;
        } else {
            if (tongueSpeed > fly.getSpeed()) {
                fly.setMass(0);
                if (fly.getMass() >= 0.5 * age) {
                    grow();
                }
            } else {
                fly.grow(1);
            }
        }
    }

    public String toString() {
        if (isFroglet) {
            return "My name is " + name + " and I知 a rare froglet! I知 " + age + " months old and my tongue has a speed of " + tongueSpeed +".";
        } else {
            return "My name is " + name + " and I知 a rare frog. I知 " + age + " months old and my tongue has a speed of " + tongueSpeed + ".";
        }
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}