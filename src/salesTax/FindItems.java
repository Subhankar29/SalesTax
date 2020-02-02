package salesTax;

import java.util.Arrays;

public class FindItems {

	public static String[] excemptItems = {"book", "books","food", "medical product", "books", "foods", "medical products", "chocolate", "headache pills", "chocolates"};
	
	public static boolean excemptItems(String items) {
		if(Arrays.stream(excemptItems).anyMatch(items::contains)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean searchForImportedProduct(String items) {
		if(items.toLowerCase().indexOf("imported") != -1) {
			return true;
		}else {
			return false;
		}
	}
}
