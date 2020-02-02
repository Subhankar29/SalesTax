package salesTax;

public class Calculate {
	
	public static double calculateImportTax(int numberOfProducts, double costOfProducts) {
		
		double importTaxOnItems = numberOfProducts*costOfProducts*0.05;
		importTaxOnItems = roundNumber(importTaxOnItems);
		return importTaxOnItems;
		
	}
	
	public static double calculateTaxImportedItems(int numberOfProducts, double costOfProducts) {
		
		double importOnProduct = numberOfProducts*costOfProducts*0.15;
		importOnProduct = roundNumber1(importOnProduct);
		return importOnProduct;
	}
	
	public static double totalImportAndSalesAmount(int numberOfProducts, double costOfProducts) {
		
		double importAmount = numberOfProducts*costOfProducts*1.15;
		importAmount = roundNumber(importAmount);
		return importAmount;
	}
	
	public static double totalImportAmount(int numberOfProducts, double costOfProducts) {
		
		double importAmount = numberOfProducts*costOfProducts*1.05;
		importAmount = roundNumber1(importAmount);
		return importAmount;
	}
	
	public static double calculateSalesTax(int numberOfProducts, double costOfProducts) {
		
		double salesTaxOnProduct = numberOfProducts*costOfProducts*0.10;
		salesTaxOnProduct = roundNumber(salesTaxOnProduct);
		return salesTaxOnProduct;
	}
	
	public static double roundNumber(double number) {
		number = (Math.round(number * 20)) / 20.0;
		return number;
	}
	
	public static double roundNumber1(double number) {
		number = (Math.round(number * 100)) / 100.0;
		return number;
	}

}
