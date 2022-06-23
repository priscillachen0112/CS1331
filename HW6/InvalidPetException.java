public class InvalidPetException extends RuntimeException {
    public void InvalidPetException() {
        System.out.println("Your pet is invalid!");
    }

    public void InvalidPetException(String s) {
        System.out.println(s);
    }
}