import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Clinic {
    private File patientFile;
    private int day;

    public Clinic(File file) {
        File patientFile = new File(String.valueOf(file));
        day = 1;
    }

    public Clinic(String fileName) {
        super();
        String patientFile = new String(fileName);
        day = 1;
    }

    public String nextDay(File f) throws FileNotFoundException, InvalidPetException {
        String fileName = new String(String.valueOf(f));
        return nextDay(fileName);
    }

    public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException {
        File apptFile = new File(fileName);
        Scanner fileScan = null;
        String[] tokens = null;

        String[] names = new String[5];
        String[] typeOfPet = new String[5];
        double[] miceCaughtOrDroolRate = new double[5];
        String[] entryTime = new String[5];
        String[] exitTime = new String[5];
        int[] minTreat = new int[5];


        int index = 0;

        fileScan = new Scanner(apptFile);
        String line = null;

        String[] petInfo = new String[8];

        String output = "";

        while (index < 5 && fileScan.hasNextLine()) {
            line = fileScan.nextLine();
            tokens = line.split(",");
            names[index] = tokens[0];
            typeOfPet[index] = tokens[1];
            miceCaughtOrDroolRate[index] = Double.parseDouble(tokens[2]);
            entryTime[index] = tokens[3];

            if (!Arrays.asList("Dog", "Cat").contains(typeOfPet[index])) {
                throw new InvalidPetException();
            }

            Scanner userInput = new Scanner(System.in);
            boolean successHealthInput = false;
            boolean successPainLevel = false;
            double initialHealth = 1.0;
            int initialPainLevel = 1;

            while (!successHealthInput) {
                try {
                    System.out.println("Consultation for " + names[index] +
                            " the " + typeOfPet[index] + " at " + entryTime[index] +
                            ".\nWhat is the health of " + names[index] + "?\n");
                    initialHealth = userInput.nextDouble();
                    successHealthInput = true;
                } catch (InputMismatchException e) {
                    userInput.nextLine();
                    System.out.println("Please enter a number");
                }
            }

            while (!successPainLevel) {
                try {
                    System.out.println("On a scale of 1 to 10, how much pain is " +
                                    names[index] + " in right now?\n");
                    initialPainLevel = userInput.nextInt();
                    successPainLevel = true;
                } catch (InputMismatchException e) {
                    userInput.nextLine();
                    System.out.println("Please enter a number");
                }
            }

            if (typeOfPet[index].equals("Dog")) {
                Dog currentDog = new Dog(names[index], initialHealth, initialPainLevel, miceCaughtOrDroolRate[index]);
                currentDog.speak();
                minTreat[index] = currentDog.treat();
            } else if (typeOfPet[index].equals("Cat")) {
                Cat currentCat = new Cat(names[index], initialHealth, initialPainLevel, (int) miceCaughtOrDroolRate[index]);
                currentCat.speak();
                minTreat[index] = currentCat.treat();
            }
            exitTime[index] = addTime(entryTime[index], minTreat[index]);

            petInfo[0] = names[index];
            petInfo[1] = typeOfPet[index];
            petInfo[2] = String.valueOf(miceCaughtOrDroolRate[index]);
            petInfo[3] = "Day " + day;
            petInfo[4] = entryTime[index];
            petInfo[5] = exitTime[index];
            petInfo[6] = String.valueOf(initialHealth);
            petInfo[7] = String.valueOf(initialPainLevel);

            String petInfoStr;
            petInfoStr = String.join(",", petInfo);
            output = output + petInfoStr + "\n";
            index++;
        }
        day++;
        return output;
     }


    public boolean addToFile(String patientInfo, File fileOut) {
        PrintWriter filePrint = null;

        try {
            filePrint = new PrintWriter(fileOut);
            System.out.println(patientInfo);
            filePrint.append(patientInfo);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (filePrint != null) {
                filePrint.close();
            }
        }
        return true;
    }

    private String addTime(String timeIn, int treatmentTime) {
        String timeOutString;

        int hour = Integer.parseInt(timeIn.substring(0, 2));
        int minute = Integer.parseInt(timeIn.substring(2, 4));

        int timeOutMinute = hour * 60 + minute + treatmentTime;

        if (timeOutMinute > 59) {
            hour = timeOutMinute / 60;
            minute = timeOutMinute - hour * 60;
        }

        timeOutString = String.valueOf(hour) + String.valueOf(minute);

        if (hour <= 9) {
            timeOutString = "0" + timeOutString;
        }
        return timeOutString;
    }
}