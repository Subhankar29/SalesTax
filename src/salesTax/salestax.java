package salesTax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import salesTax.Calculate;
import salesTax.FindItems;;

public class salestax {
	
	static String sentence="";
	static int numberOfProducts;
	static int length;
	static double salesTax = 0;
	static double importTax = 0;
	static double total = 0;
	static String items;
	static double costOfProducts;
	double salesTaxAmount = 0.10;
	static double totalTax= 0;

	public static void main(String[] args) {
	
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder itemList = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		
		// Taking the number of products: 
		System.out.println("INPUT THE NUMBER OF ITEMS:");
		int number = scanner.nextInt();
		
		System.out.println("INPUT FORMAT: <NUMBER OF PRODUCTS> <ITEM AND DESCRIPTION> <PRICE OF THE PRODUCT>");
		
		// Input the products:
		for(int i = 0; i<= number -1; i++) {
			System.out.println("Input the products:");
			try {
				sentence = ob.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String[] differentItems = sentence.split(" ");
			
			numberOfProducts = Integer.parseInt(differentItems[0]);
			length = (differentItems.length);
			costOfProducts = Double.parseDouble(differentItems[length - 1]);
			items = Arrays.toString(Arrays.copyOfRange(differentItems, 1, length - 2)).replace("[", "").replace("]", "").replace(",", "");
			
			//Calculating the Total Tax amount:
			
			if(!(FindItems.excemptItems(sentence))){
				
				if(FindItems.searchForImportedProduct(sentence)) {
					
//					System.out.println("Imported item found");
					importTax = importTax + (Calculate.calculateTaxImportedItems(numberOfProducts, costOfProducts));
					itemList.append("\n"+numberOfProducts + " " +items + ":" + ((Calculate.totalImportAndSalesAmount(numberOfProducts, costOfProducts))));
					
				} else {
					
//					System.out.println("Item which if not imported");
					salesTax = salesTax + (Calculate.calculateSalesTax(numberOfProducts, costOfProducts));
					itemList.append("\n"+numberOfProducts + " " +items + ":" + Calculate.roundNumber1(((costOfProducts*numberOfProducts) + salesTax)));
					
				}
				
			}else {
				if(FindItems.searchForImportedProduct(sentence)) {
					
//					System.out.println("Imported food found");
					importTax = importTax + (Calculate.calculateImportTax(numberOfProducts, costOfProducts));
					itemList.append("\n"+numberOfProducts + " " +items + ":" + (Calculate.totalImportAmount(numberOfProducts, costOfProducts)));
					
				}else {
					itemList.append("\n"+numberOfProducts + " " +items + ":" + ((costOfProducts*numberOfProducts)));
				}
				
			}
			total = total + (costOfProducts*numberOfProducts);
		}
		
		
		System.out.println(itemList);
		totalTax = salesTax + importTax;
		totalTax = Calculate.roundNumber(totalTax);
		System.out.println("Sales Taxes :" + totalTax);
		total = total + salesTax + importTax;
		total = Calculate.roundNumber1(total);
		System.out.println("Total : " + total);
		scanner.close();
	}
	
}
