public class Cat extends Pet {
    private int miceCaught;
    public static final int default_miceCaught = 0;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);

        if (miceCaught < default_miceCaught) {
            miceCaught = default_miceCaught;
        }
        this.miceCaught = miceCaught;
    }

    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, default_miceCaught);
    }

    public int getMiceCaught() {
        return miceCaught;
    }

    public int treat() {
        int minTreat;
        double doubleTreat;
        if (miceCaught < 4) {
            doubleTreat = (getPainLevel() * 2) / getHealth();
        } else if (miceCaught >= 4 && miceCaught <= 7) {
            doubleTreat = getPainLevel() / getHealth();
        } else {
            doubleTreat = getPainLevel() / (getHealth() * 2);
        }
        minTreat = (int) doubleTreat;
        heal();
        return minTreat;
    }

    public void speak() {
        super.speak();
        for (int i=0; i<miceCaught; i++){
            if (getPainLevel() > 5) {
                System.out.print("meow ".toUpperCase());
            } else {
                System.out.print("meow ");
            }
        }
    }

    public boolean equals(Object o) {
        super.equals(o);
        if (o instanceof Cat) {
            Cat cat = (Cat) o;
            return this.name.equals(cat.name)
                    && this.miceCaught == cat.getMiceCaught();
        }
        return false;
    }
}