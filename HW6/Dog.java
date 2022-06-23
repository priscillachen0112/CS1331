import java.util.Locale;

public class Dog extends Pet {
    private double droolRate;
    public static final double min_droolRate = 0.0;
    public static final double default_droolRate = 5.0;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);

        if (droolRate <= min_droolRate) {
            droolRate = 0.5;
        }
        this.droolRate = droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, default_droolRate);
    }

    public double getDroolRate() {
        return droolRate;
    }

    public int treat() {
        int minTreat;
        double doubleTreat;
        if (droolRate < 3.5) {
            doubleTreat = (this.getPainLevel() * 2) / this.getHealth();
        } else if (droolRate >= 3.5 && droolRate <= 7.5) {
            doubleTreat = this.getPainLevel() / this.getHealth();
        } else {
            doubleTreat = this.getPainLevel() / (this.getHealth() * 2);
        }
        minTreat = (int) doubleTreat;
        heal();
        return minTreat;
    }

    public void speak() {
        super.speak();
        for (int i=0; i<painLevel; i++){
            if (getPainLevel() > 5) {
                System.out.print("bark ".toUpperCase());
            } else {
                System.out.print("bark ");
            }
        }
    }

    public boolean equals(Object o) {
        super.equals(o);
        if (o instanceof Dog) {
            Dog dog = (Dog) o;
            return this.name.equals(dog.name)
                    && this.droolRate == dog.getDroolRate();
        }
        return false;
    }
}