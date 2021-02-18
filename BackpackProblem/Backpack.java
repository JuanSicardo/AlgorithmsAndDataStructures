/*Author: Juan Antonio Sicardo Contreras
* Date: Fall of 2019
* Description: This programs solves the Backpack Problem using dynamic programming
* algorithms.
* The Backpack Problem goes like this: A burglar breaks into a jewelry store. To
* carry all the stolen objects, he has a backpack which has a certain weight 
* capacity, if the capacity of the backpack is surpassed, it may brake and
* all the stolen objects would be lost. Each object in the jewelry store has an associated
* weight and profit the burglar can if the object is sold in the black market.
* Inside the store, the burglar already knows how heavy and how profitable each
* item is, so now he wants to know which items he can steal that wont surpass
* the capacity of his backpack while making the most profit.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Backpack{

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);

		//Asks for the backpack weight capacity
		System.out.print("Backpack capacity: ");
		int capacity = scanner.nextInt();
		System.out.println();

		//Asks how many objects there are to steal
		System.out.print("Number of objects: ");
		int numberOfObjects = scanner.nextInt();
		System.out.println();

		StolenObject objectList[] = new StolenObject[numberOfObjects];

		for(int i = 0; i < numberOfObjects; i++){
			StolenObject stolenObject = new StolenObject();

			System.out.printf("Name of object %d: ", i + 1);
			String name = scanner.next().trim();
			stolenObject.setName(name);

			System.out.printf("Profit of %s: ", name);
			int profit = scanner.nextInt();
			stolenObject.setProfit(profit);

			System.out.printf("Weight of %s: ", name);
			int weight = scanner.nextInt();
			stolenObject.setWeight(weight);

			System.out.println();

			objectList[i] = stolenObject;
		}

		//The table is used in this algorithm to know which objects
		//should be stolen
		Table table = new Table(objectList, capacity);
		table.fill();
		table.mark();

		TableFrame tableFrame = new TableFrame(table);
		tableFrame.build();
		tableFrame.setVisible(true);

		int numberOfMarks = table.getNumberOfMarks();

		for(int m = 0; m < numberOfMarks; m++){
			ArrayList<String> stolenObjects = table.getStolenObjects(m);

			for(int i = 0; i < stolenObjects.size(); i++)
				System.out.print(stolenObjects.get(i) + ",");

			System.out.println();
		}
	}
}