import java.sql.SQLOutput;

public class Gameplay {
    
    public static void main(String[] args) {
        BlueAstronaut ba1 = new BlueAstronaut("Bob", 30, 6, 30);
        BlueAstronaut ba2 = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut ba3 = new BlueAstronaut("Albert", 20, 2, 0);
        BlueAstronaut ba4 = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut ra1 = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut ra2 = new RedAstronaut("Suspicious Person", 100, "expert");

        ra2.emergencyMeeting();
        System.out.println(ba1);
        System.out.println(ba2);
        System.out.println(ba3);
        System.out.println(ra2);
        /* ra1.sabotage(ba1);
        System.out.println(ba1);
        ra1.freeze(ra2);
        System.out.println(ra2);
        ra1.freeze(ba3);
        System.out.println(ra1);
        System.out.println(ba3);

        ba3.emergencyMeeting();
        System.out.println(ba3);
        System.out.println(ra2);
        ra2.emergencyMeeting();
        System.out.println(ba1);
        System.out.println(ba2);
        //ba1.emergencyMeeting();
        // System.out.println(ra2.isFrozen());

        //ba4.emergencyMeeting();
        //System.out.println(ra1.isFrozen()); */
    }
}