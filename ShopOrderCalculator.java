import java.util.Scanner;


public class ShopOrderCalculator {
    //Register: items names and prices
    static String[] items ={"apple","banana","orange","grape","pear",};
    static  double[] prices = {0.75, 0.45, 0.50, 0.09, 0.60};

    public static void main(String[] args) {
        int[] quantities = new int[items.length];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < items.length; i++) {
            System.out.println("How many " + items[i] + "s do you want?");
            quantities[i] = Integer.parseInt(sc.nextLine());
        }
        double totalWithoutTax = calculateCost(quantities);
        double taxRate = shouldApplyTax(totalWithoutTax) ? 0.08 : 0.0;
        double totalTax = totalWithoutTax * taxRate;
        double totalWithTax = totalWithoutTax + totalTax;

        System.out.println("\nOrder Summary:");
        printOrderSummary(quantities);
        System.out.printf("Total (without tax): $%.2f\n ", totalWithTax);
        System.out.printf("Sales Tax: $%.2f\n ", totalTax);
        System.out.printf("Total (with tax): $%.2f\n ", totalWithTax);

        double newTaxrate = 0.0225;
        double newTax = totalWithTax * newTaxrate;
        double newTotal = totalWithTax + newTax;
        System.out.printf("\nTotal with 2.25%% Tax: $%.2f\n ", newTotal);

        sc.close();
    }
    public static double calculateCost(int[] quantities) {
        double total = 0.0;
        for (int i = 0; i < items.length; i++) {
            total += quantities[i] * prices[i];
        }
        return total;
    }
    public static void printOrderSummary(int[] quantities) {
        for (int i = 0; i < items.length; i++) {
            if (quantities[i] > 0) {
                System.out.printf("%s: %d x $%.2f = $%.2f\n",items[i], quantities[i], prices[i],quantities[i] * prices[i]);
            }
        }
    }
    public static boolean shouldApplyTax(double totalWithoutTax) {
        return totalWithoutTax >= 10.0;
    }
}
