package cmsc256;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DogNamesLab   {
    private static String promptForFileName() {
        System.out.println("Enter the file name: ");
        @SuppressWarnings("resource")
        Scanner keyIn = new Scanner(System.in);
        return keyIn.next();
    }

    private static Scanner openFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        while (!file.exists()) {
            file = new File(promptForFileName());
        }
        return new Scanner(file);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read data file to build data structure
        ArrayList<Dog> doglist = new ArrayList<>();

        try {
            // verify file and create file Scanner
            Scanner fileReader = openFile("Dog_Names.csv");

            //  Discard header line
            fileReader.nextLine();

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                int commaIndex = line.indexOf(',');
                String name = line.substring(0, commaIndex).trim();
                int count = Integer.parseInt(line.substring(commaIndex + 1).trim());
                doglist.add(new Dog(name, count));
            }
            fileReader.close();
        } catch (FileNotFoundException noFile) {
            System.out.println("There was an error opening or reading from the file.");
            System.exit(0);
        }

        Scanner readInput = new Scanner(System.in);
        String prompt = "\nWhat do you want to do?\n"
                + "\t1. Check a dog name\n" + "\t2. See all the dog names\n"
                + "\t3. Play a game\n" + "\t4. Exit"
                + ".\n"
                + "Enter the number corresponding to your choice.";

        System.out.println(prompt);
        int option = readInput.nextInt();

        switch (option) {
            case 1:
                System.out.println("Enter a dog’s name?");
                String name = in.nextLine();
                int nameCount = getCountForDog(doglist, name);
                System.out.println(name + " is registered " + nameCount + " times.");
                break;
            case 2:
                System.out.println(getDogNamesAlphabetically(doglist));
                break;
            case 3:
                playGuessingGame(doglist, in);
                break;
            default:
                System.out.println("Invalid option.");
        }
        in.close();
    }

    public static int getCountForDog(ArrayList<Dog> dogs, String name) {
        int numOfRegistrations = 0;
        for(int i = 0; i < dogs.size(); i++){
            if(dogs.get(i).getDogName().equals(name)){
                numOfRegistrations = dogs.get(i).getCount();
            }
        }
        return numOfRegistrations;
    }

    public static String getDogNamesAlphabetically(ArrayList<Dog> dogs) {
        StringBuilder dogNames = new StringBuilder();

        Collections.sort(dogs);

        for(int i = 0; i < dogs.size(); i++){
            dogNames.append(dogs.get(i).getDogName());
            dogNames.append(" ");

        }

        return String.valueOf(dogNames);
    }

    public static void playGuessingGame(ArrayList<Dog> dogs, Scanner readIn) {





        }


    }
