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
    // Frog had initial age 5 and initial tongue speed 5.
    // It was grown by 8 months and did not have proper final tongue speed.
    //expected:<12> but was:<5>

    // Frog had initial age 31 and initial tongue speed 20.
    // It was grown by 8 months and did not have proper final tongue speed.
    //expected:<12> but was:<11>

    //Frog had initial age 25 and initial tongue speed 30. It was grown by 10 months and did not have proper final tongue speed.
    //expected:<25> but was:<26>

    //Frog had initial age 7 and initial tongue speed 40. It was grown by 4 months and did not have proper final tongue speed.
    //expected:<44> but was:<12>

    //Frog had initial age 9000 and initial tongue speed 6. It was grown by 12 months and did not have proper final tongue speed.
    //expected:<5> but was:<6>

    //Then it ages the Frog by the given number of months and increases tongueSpeed by 1 for every month the Frog grows until it becomes 12 months old.
    //If the Frog is 30 months old or more, then decrease tongueSpeed by 1 for every month that it ages beyond 30 months.
    //You must not decrease tongueSpeed to less than 5.

    //Frog had initial age 12 and initial tongue speed 8. It was grown by 15 months and did not have proper final tongue speed.
    //expected:<8> but was:<12>

    //Frog had initial age 213 and initial tongue speed 9. It was grown by 0 months and did not have proper final tongue speed.
    //expected:<9> but was:<5>

    //Frog had initial age 5 and initial tongue speed 5. It was grown by 5 months and did not have proper final tongue speed.
    //expected:<10> but was:<12>
    public void grow(int months) {
        int initialAge = age;
        age = age + months;
        if (months == 0) {
            return;
        }
        if (initialAge <= 12 && tongueSpeed <= 12) {
            int speedGainMonths = 12-initialAge;
            tongueSpeed = tongueSpeed + Math.min(months, speedGainMonths);
        } else if (age <= 12 && tongueSpeed > 12) {
            tongueSpeed = tongueSpeed + months;
        } else if (age > 12 && age < 30) {

        } else if (age >= 30) {
            if ((tongueSpeed - (age-31) >= 5)) {
                tongueSpeed = tongueSpeed - (age-Math.max(30, initialAge));
            } else {
                tongueSpeed = 5;
            }
        }
        this.isFroglet(age);
    }
    // Frog does not have correct tongueSpeed expected:<39.0> but was:<29.0>
    public void grow() {
        int initialAge = age;
        age = age + 1;
        if (initialAge <= 12 && tongueSpeed <= 12) {
            int speedGainMonths = 12-initialAge;
            tongueSpeed = tongueSpeed + Math.min(1, speedGainMonths);
        } else if (age <= 12 && tongueSpeed > 12) {
            tongueSpeed = tongueSpeed + 1;
        } else if (age > 12 && age < 30) {

        } else if (age >= 30) {
            if ((tongueSpeed - (age-31) >= 5)) {
                tongueSpeed = tongueSpeed - (age-Math.max(30, initialAge));
            } else {
                tongueSpeed = 5;
            }
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
            return "My name is " + name + " and I知 a rare froglet! I知 " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) +".";
        } else {
            return "My name is " + name + " and I知 a rare frog. I知 " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
        }
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}