public abstract class Pet {
    protected String name;
    protected double health;
    protected int painLevel;

    public static final double min_health = 0.0;
    public static final double max_health = 1.0;
    public static final int max_painLevel = 10;
    public static final int min_painLevel = 1;

    public Pet(String name, double health, int painLevel) {
        if (health > max_health) {
            health = max_health;
        } else if (health < min_health) {
            health = min_health;
        }
        if (painLevel > max_painLevel) {
            painLevel = max_painLevel;
        } else if (painLevel < min_painLevel) {
            painLevel = min_painLevel;
        }
        this.name = name;
        this.health = health;
        this.painLevel = painLevel;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public int getPainLevel() {
        return painLevel;
    }

    // An abstract method that returns the time taken (in minutes)
    // to treat the pet.
    public abstract int treat();

    public void speak() {
        String speakString = "Hello! My name is " + this.name;
        if (this.painLevel > 5) {
            System.out.println(speakString.toUpperCase());
        } else {
            System.out.println(speakString);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Pet) {
            Pet pet = (Pet) o;
            return this.name.equals(pet.name);
        }
        return false;
    }

    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }
}