public class Inventory{
	double costPrice;
	double sellingPrice;
	int quantity;
	Inventory(String costPrice, String sellingPrice){
		this.costPrice = (double) (Math.round(Float.parseFloat(costPrice) * 100.0) / 100.0);
		this.sellingPrice = (double) (Math.round(Float.parseFloat(sellingPrice) * 100.0) / 100.0);
		this.quantity = 0;
	}
}