import java.util.Scanner;

public class ElectricityBillingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of units consumed:");
        int unitsConsumed = scanner.nextInt();
        
        double billAmount = calculateBill(unitsConsumed);
        
        System.out.println("Electricity Bill: $" + billAmount);
        
        scanner.close();
    }
    
    public static double calculateBill(int unitsConsumed) {
        double billAmount = 0;
        if(unitsConsumed <= 100) {
            billAmount = unitsConsumed * 1.20;
        } else if(unitsConsumed > 100 && unitsConsumed <= 300) {
            billAmount = 100 * 1.20 + (unitsConsumed - 100) * 2;
        } else if(unitsConsumed > 300 && unitsConsumed <= 500) {
            billAmount = 100 * 1.20 + 200 * 2 + (unitsConsumed - 300) * 3;
        } else {
            billAmount = 100 * 1.20 + 200 * 2 + 200 * 3 + (unitsConsumed - 500) * 4.50;
        }
        return billAmount;
    }
}
