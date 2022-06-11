public class Pond {
    public static void main(String[] args) {
        Frog frog1 = new Frog("Peepo");
        Frog frog2 = new Frog("Pepe", 10, 15);
        Frog frog3 = new Frog("Peepaw", 4.6);
        Frog frog4 = new Frog("Wawa", 12, 10);

        Fly fly1 = new Fly(1,3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly(2, 4);

        //Set the species of any Frog to “1331 Frogs”

        frog1.setSpecies("1331 Frogs");

        //Print out on a new line the description of the Frog named Peepo given by the toString method.

        System.out.println(frog1.toString());

        //Have the Frog named Peepo attempt to eat the Fly with a mass of 6.

        frog1.eat(fly2);

        //Print out on a new line the description of the Fly with a mass of 6 given by the toString method.

        System.out.println(fly2.toString());

        //Have the Frog named Peepo grow by 8 months.

        frog1.grow(8);

        //Have the Frog named Peepo attempt to eat the Fly with a mass of 6.

        frog1.eat(fly2);

        //Print out on a new line the description of the Fly with a mass of 6 given by the toString method.

        System.out.println(fly2.toString());

        //Print out on a new line the description of the Frog named Peepo given by the toString method.

        System.out.println(frog1.toString());

        //Print out on a new line the description of your own Frog given by the toString method.

        System.out.println(fly3.toString());

        //Have the Frog named Peepaw grow by 4 months.

        frog3.grow(4);

        //Print out on a new line the description of the Frog named Peepaw given by the toString method.

        System.out.println(frog3.toString());

        //Print out on a new line the description of the Frog named Pepe given by the toString method.

        System.out.println(frog2.toString());
    }
}