/*Exercise 4-2: Modify the Invoice Application 
 * SDE194: Dr. Darin Mills 
 * Deanna R.I. Burke 
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class InvoiceApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        
        

        while (!choice.equalsIgnoreCase("n")) {
            // get the input from the user
            System.out.print("Enter customer type (r/c/t): ");
            String customerType = sc.nextLine();
            
            System.out.print("Enter subtotal:   ");
            double subtotal = Double.parseDouble(sc.nextLine());

            // get the discount percent
           /*double discountPercent = switch(customerType) {
                //modified code so that customer that ha subtotal of <500 get .3 and between 250-500 get .25
                case "r", "R" -> {
                    if (subtotal >= 500) {
                        yield .3;
                    } else if (subtotal >= 250 && subtotal < 500) {
                        yield .25;
                    } else {  
                        yield 0.0;
                    } 
                }
                case "c", "C" -> {
                    //if (subtotal >= 250) {
                        //yield .3;
                    //} else {
                        //yield .2;
                    //}
                		yield .2;
                }
                //added customer type T and corresponding discounts 
                case "t", "T" -> {
                	if (subtotal >= 500) {
                		yield .5;
                	} else if (subtotal <= 500) {
                		yield .4; 
                	} else {
                		yield 0.0; 
                	}
                }
                default -> .1;
                  
                
            }; */
            
            //code to get discount percentage based on customer type 
            //using if/else statments 
            //setting .1 as default since that was what as used in the switch statement 
            double discountPercent = .1; 
            
           if (customerType.equalsIgnoreCase("r"))
           {
        	   if (subtotal >= 500)
        	   {
        		   discountPercent = .3; 
        	   } 
        	   else if (subtotal >= 250)
        	   {
        		   discountPercent = .25; 
        	   } 
        	   else if (subtotal >= 100)
        	   {
        		   discountPercent = .1; 
        	   } 
        	   else
        	   {
        		   discountPercent = 0.0; 
        	   }
           } 
           else if (customerType.equalsIgnoreCase("c"))
           {
        	   discountPercent = .2; 
           }
           else if (customerType.equalsIgnoreCase("t"))
           {
        	   if (subtotal <500)
        	   {
        		   discountPercent = .4; 
        	   }
        	   else
        	   {
        		   discountPercent =.5; 
        	   }
           }
            // calculate the discount amount and round to 2 decimals
            double discountAmount = subtotal * discountPercent;
            discountAmount = Math.ceil(discountAmount * 100) / 100;

            // calculate the total
            double total = subtotal - discountAmount;

            // format and display the results
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            System.out.println(
                "Discount percent: " + percent.format(discountPercent) + "\n"
              + "Discount amount:  " + currency.format(discountAmount) + "\n"
              + "Total:            " + currency.format(total) + "\n");

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
    }
}