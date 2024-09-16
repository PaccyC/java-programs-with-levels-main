import java.util.Scanner;

public class TemperatureConverter {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the temperature value: ");
        double tempValue= scanner.nextDouble();

        System.out.println("choose the initial unit of temperature: ");
        for (Units unit:Units.values()){
            System.out.println(unit.ordinal() + 1 + ": " + unit);
        }
        // Get the user's choice
        System.out.print("Enter the number corresponding to the unit: ");
        int unitChoice = scanner.nextInt();

        switch (unitChoice){
            case 1 -> {
                double fahrenheitTemp=tempValue*9/5+32;
                System.out.println(tempValue + "°C is equal to " + fahrenheitTemp + "°F.");

            }
            case 2 -> {
                double celsiusTemp=(tempValue-32)*5/9;
                System.out.println(tempValue + "°F is equal to " + celsiusTemp + "°C.");
            }


        }
        scanner.close();

    }



}
