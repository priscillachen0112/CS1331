public class Pond {
    public static void main(String[] args) {
        Frog frog1 = new Frog("Peepo");
        Frog frog2 = new Frog("Pepe", 10, 15);
        Frog frog3 = new Frog("Peepaw", 4.6);
        Frog frog4 = new Frog("Wawa");

        Fly fly1 = new Fly(1,3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly();

        frog1.setSpecies("1331 Frogs");
        frog1.toString();

        frog1.eat(fly2);
        fly2.toString();
        frog1.toString();

        frog3.grow(4);
        frog3.toString();

        frog2.toString();
    }
}