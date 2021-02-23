public class StolenObject{

	private String name;
	private int weight, profit;

	public StolenObject(){
		name = null;
		weight = -1;
		profit = -1;
	}

	public StolenObject(String name){
		this.name = name;
		weight = -1;
		profit = -1;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
		return weight;
	}

	public void setProfit(int profit){
		this.profit = profit;
	}

	public int getProfit(){
		return profit;
	}
}