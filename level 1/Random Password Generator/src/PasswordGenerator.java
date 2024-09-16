import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();


//        Character Sets
        String numbers = "0123456789";
        String uppercaseCharacters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseCharacters="abcdefghijklmnopqrstuvwxyz";
        String specialCharacters="!@#$%^&*()-_+=<>?";

        System.out.println("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.println("Include numbers(true/false)");
        boolean includeNumbers = scanner.nextBoolean();
        System.out.println("Include lower case characters (true or false): ");
        boolean includeLowercaseCharacters = scanner.nextBoolean();
        System.out.println("Include uppercase characters (true or false): ");
        boolean includeUppercaseCharacters = scanner.nextBoolean();
        System.out.println("Include special characters (true or false): ");
        boolean includeSpecialCharacters = scanner.nextBoolean();

//        Building character pool base on user preferences
        StringBuilder characterPool= new StringBuilder();

        if (includeNumbers){
            characterPool.append(numbers);
        }
        if (includeLowercaseCharacters){
            characterPool.append(lowercaseCharacters);
        }
        if (includeUppercaseCharacters){
            characterPool.append(uppercaseCharacters);
        }
        if (includeSpecialCharacters){
            characterPool.append(specialCharacters);
        }

        if (characterPool.length() == 0){
            System.out.println("Password is empty: You must enter at least one character");
        }
        StringBuilder password = new StringBuilder();
        for ( int i=0; i<length;i++){
//            Generating random password
            int index = rand.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        System.out.println("Generated password: " + password.toString());

    }
}
