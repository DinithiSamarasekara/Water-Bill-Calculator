package waterBillsCalculator;
import java.util.Scanner;

public class WaterBill {
	

	 private int billNumber;
	    private int units;
	    private double billAmount;
	    
	 // static variable for the unit price  
	    private static double unitPrice = 12.0; 
	    
	    
	 // calculate bill amount

	    public WaterBill(int billNumber, int units) {
	        this.billNumber = billNumber;
	        this.units = units;
	        this.billAmount = units * unitPrice; 
	    }
	    
	  // calculate Discount  

	    private double calculateDiscount() {
	        if (units >= 200) {
	            return 0.06 * billAmount;
	        } else if (units >= 100 && units < 200) {
	            return 0.02 * billAmount;
	        } else {
	            return 0.0;
	        }
	    }
	    
	    // calculate Final Amount

	    private double calculateFinalAmount() {
	        double discountAmount = calculateDiscount();
	        double finalAmount = billAmount - discountAmount;
	        return finalAmount;
	    }
	    
	 // function to change unit price for all bills

	    public static void setUnitPrice(double price) {
	        unitPrice = price; 
	    }

	    public void printFinalAmount() {
	        double finalAmount = calculateFinalAmount();
	        System.out.printf("Bill #%d: final amount = RS: %.2f\n", billNumber, finalAmount);
	    }

	    public static void main(String[] args) {
	        WaterBill bill1 = inputData();
	        WaterBill bill2 = inputData();

	        bill1.printFinalAmount();
	        bill2.printFinalAmount();
	        
	     // change unit price to Rs 16
	        WaterBill.setUnitPrice(16.0); 

	        WaterBill bill3 = inputData();
	        bill3.printFinalAmount();
	    }

	    public static WaterBill inputData() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the bill number: ");
	        int billNumber = scanner.nextInt();
	        
	        
	        System.out.print("Enter the number of units: ");
	        int units = scanner.nextInt();
	        return new WaterBill(billNumber, units);
	    }
	}
	   

	


