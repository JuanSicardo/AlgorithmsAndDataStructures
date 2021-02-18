/*Author: Juan Antonio Sicardo Contreras
* Date: Fall of 2019
* Description: This simply is an object class to store the data of a cell
* in the table.
*/

public class Cell{

	private boolean didEnter, isMarked, isEmpty;
	private int provenanceRow, provenanceColumn, acumulatedProfit, mark;

	public Cell(){
		isEmpty = false;
		didEnter = false;
		provenanceRow = -1;
		provenanceColumn = -1;
		acumulatedProfit = 0;
		isMarked = false;
		mark = -1;
	}

	public Cell(boolean isEmpty){
		this.isEmpty = isEmpty;
		didEnter = false;
		provenanceRow = -1;
		provenanceColumn = -1;
		acumulatedProfit = 0;
		isMarked = false;
		mark = -1;
	}

	public void setDidEnter(boolean state){
		didEnter = state;
	}

	public boolean didEnter(){
		return didEnter;
	}

	public void setProvenanceRow(int provenanceRow){
		this.provenanceRow = provenanceRow;
	}

	public int getProvenanceRow(){
		return provenanceRow;
	}

	public void setProvenanceColumn(int provenanceColumn){
		this.provenanceColumn = provenanceColumn;
	}

	public int getProvenanceColumn(){
		return provenanceColumn;
	}

	public void setAcumulatedProfit(int acumulatedProfit){
		this.acumulatedProfit = acumulatedProfit;
	}

	public int getAcumulatedProfit(){
		return acumulatedProfit;
	}

	public void mark(int mark){
		isMarked = true;
		this.mark = mark;
	}

	public int getMark(){
		return mark;
	}

	public boolean isMarked(){
		return isMarked;
	}

	public boolean isEmpty(){
		return isEmpty;
	}
}