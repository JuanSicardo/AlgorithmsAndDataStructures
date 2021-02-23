/*
* Author: Juan Antonio Sicardo Contreras
* Date: Fall of 2019
* Description: This table is a representation of the data in the backpack
* problem. It's main utility is store in memory different possible convination
* of stolen objects. Each convination is a track, and is called that because
* we add object iteratively to each track, if one track is worse in every aspect
* than another one, that track is eliminated an thus we continue working only with
* the best tracks.
*/

import java.util.ArrayList;

public class Table{

	private int numberOfRows, numberOfColumns, numberOfMarks;
	private StolenObject objectList[];
	private Cell table[][];

	public Table(StolenObject objectList[], int capacity){
		this.objectList = objectList;
		numberOfRows = objectList.length + 1;
		numberOfColumns = capacity + 1;
		table = new Cell[numberOfRows][numberOfColumns];
	}

	//Returns how many rows the table has
	public int getNumberOfRows(){
		return numberOfRows;
	}

	//Returns how many columns the table has
	public int getNumberOfColumns(){
		return numberOfColumns;
	}

	//Returns a cell of the table
	public Cell cellAt(int row, int column){
		return table[row][column];
	}

	//Clears the information of the table
	public void empty(){
		for(int r = 0; r < numberOfRows; r++)
			for(int c = 0; c < numberOfColumns; c++)
				table[r][c] = new Cell(true);
	}

	//Fills the table acording to the algorithm
	public void fill(){
		for(int r = 0; r < numberOfRows; r++)
			for(int c = 0; c < numberOfColumns; c++){

				//The firs row and column are empty
				if(r == 0 || c == 0)
					table[r][c] = new Cell(true);

				else{

					StolenObject currentObject = objectList[r - 1];
					int currentProfit = currentObject.getProfit();
					int currentWeight = currentObject.getWeight();

					if(c < currentWeight){
						Cell cell = new Cell();
						cell.setDidEnter(false);
						cell.setProvenanceRow(r - 1);
						cell.setProvenanceColumn(c);
						cell.setAcumulatedProfit(table[r - 1][c].getAcumulatedProfit());
						table[r][c] = cell;
					}

					else{
						Cell option1 = table[r - 1][c];
						Cell option2 = table[r - 1][c - currentWeight];

						if(option1.getAcumulatedProfit() < option2.getAcumulatedProfit() + currentProfit){
							Cell cell = new Cell();
							cell.setDidEnter(true);
							cell.setProvenanceRow(r - 1);
							cell.setProvenanceColumn(c - currentWeight);
							cell.setAcumulatedProfit(option2.getAcumulatedProfit() + currentProfit);
							table[r][c] = cell;
						}
						else{
							Cell cell = new Cell();
							cell.setDidEnter(false);
							cell.setProvenanceRow(r - 1);
							cell.setProvenanceColumn(c);
							cell.setAcumulatedProfit(option1.getAcumulatedProfit());
							table[r][c] = cell;
						}
					}
				}
			}
	}

	//Puts marks on the table, each mark is a color that serves to differentiate each track from one another
	public void mark(){
		int maxProfit = table[numberOfRows - 1][numberOfColumns - 1].getAcumulatedProfit();
		int mark = 0;

		for(int r = numberOfRows - 1; r >= 0; r--)
			for(int c = numberOfColumns - 1; c >= 0; c--){
				if(!table[r][c].isMarked() && table[r][c].getAcumulatedProfit() == maxProfit){
					markTrail(r, c, mark);
					mark++;
				}
			}

		numberOfMarks = mark;
	}

	//Marks a full trail or track
	private void markTrail(int r, int c, int mark){
		Cell cell = table[r][c];

		if(cell.isEmpty())
			return;

		if(cell.isMarked())
			return;

		cell.mark(mark);
		markTrail(cell.getProvenanceRow(), cell.getProvenanceColumn(), mark);
	}

	//Returns how many tracks the final answer has
	public int getNumberOfMarks(){
		return numberOfMarks;
	}

	public ArrayList<String> getStolenObjects(int mark){
		ArrayList<String> stolenObjects = new ArrayList<String>();

		for(int r = 0; r < numberOfRows; r++)
			for(int c = 0; c < numberOfColumns; c++){
				Cell cell = table[r][c];
				if(cell.isMarked() && cell.getMark() == mark && cell.didEnter())
					stolenObjects.add(objectList[r - 1].getName());
			}

		return stolenObjects;
	}
}