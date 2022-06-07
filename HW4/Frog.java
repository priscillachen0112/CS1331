public class Frog {
    // Instance variables
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private String species = "Rare Pepe";

    public static final int default_age = 5;
    public static final double default_speed = 5;

    // Constructors
    private Frog(String initName) {
        this(initName, default_age, default_speed);
        this.isFroglet(age);
    }

    private Frog(String initName, double ageInYears) {
        this(initName, (int) ageInYears * 12, default_speed);
        this.isFroglet(age);
    }

    private Frog(String initName, int initAge, double initSpeed) {
        this.name = initName;
        this.age = initAge;
        this.tongueSpeed = initSpeed;
    }

    private void isFroglet(int age) {
        if (age>=1 && age <=7) {
            isFroglet = true;
        } else {
            isFroglet = false;
        }
    }
}