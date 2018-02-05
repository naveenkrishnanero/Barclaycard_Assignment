import java.text.DecimalFormat;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class InventoryManager{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Map<String, Inventory> invObjects = new TreeMap<String, Inventory>();
                double profit = 0.0;
		while(true){
			String full = sc.nextLine();
                        if(full.equals("report")){
                            System.out.println("\t\t\tINVENTORY REPORT");
                            System.out.println("Item Name\tBought At\tSold At\tAvailable Qty\tValue");
                            System.out.println("---------\t---------\t-------\t-------------\t-----");
                            Iterator i = invObjects.entrySet().iterator();
                            DecimalFormat df = new DecimalFormat("#.##");
                            double totalValue = 0.0;
                            while(i.hasNext()){
                                Map.Entry me = (Map.Entry) i.next();
                                    Inventory inv = (Inventory) me.getValue();
                                totalValue += inv.costPrice*inv.quantity;
                                System.out.println(me.getKey()+"\t\t"+df.format(inv.costPrice)+"\t\t"+df.format(inv.sellingPrice)+"\t"+df.format(inv.quantity)+"\t\t"+(inv.costPrice*inv.quantity));
                            }
                            System.out.println("------------------------------------------------------------------");
                            System.out.println("Total Value\t\t\t\t\t\t"+df.format(totalValue));
                            System.out.println("Profit since previous report\t\t\t\t"+df.format(profit));
                            profit = 0.0;
                        }
                        else{
                            String[] string_words = full.split("\\s+");
                            switch(string_words[0]){
				                case "create":
                                    Inventory inv = new Inventory(string_words[2], string_words[3]);
                                    invObjects.put(string_words[1], inv);
                                    break;
                                case "delete":
                                    invObjects.remove(string_words[1]);
                                    profit -= invObjects.get(string_words[1]).costPrice * invObjects.get(string_words[1]).quantity;
                                    break;
                                case "updateBuy":
                                    invObjects.get(string_words[1]).quantity += Integer.parseInt(string_words[2]);
                                    break;
                                case "updateSell":
                                    invObjects.get(string_words[1]).quantity -= Integer.parseInt(string_words[2]);
                                    profit += ((invObjects.get(string_words[1]).sellingPrice - invObjects.get(string_words[1]).costPrice) * Integer.parseInt(string_words[2]));
                                    break;
                                default:
                                    System.exit(0);
                            }
                        }
                }
        }
}