import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class TableFrame extends JFrame{

	private Table table;
	private int frameRows, frameColumns, tableRows, tableColumns;

	public TableFrame(Table table){
		super("Backpack Problem");
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = getSize();
		setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
		this.table = table;
		tableRows = table.getNumberOfRows();
		tableColumns = table.getNumberOfColumns();
		frameRows = tableRows + 1;
		frameColumns = tableColumns + 1;
	}

	public void build(){
		JPanel panel = new JPanel(new GridLayout(frameRows, frameColumns));

		for(int fr = 0; fr < frameRows; fr++)
			for(int fc = 0; fc < frameColumns; fc++){

				JButton button = new JButton();

				int tr = fr - 1;
				int tc = fc - 1;
				
				if(fr == 0 && fc == 0)
					button.setBackground(Color.LIGHT_GRAY);

				else if(fr == 0){
					button.setText("" + tc);
					button.setBackground(Color.LIGHT_GRAY);
				}

				else if(fc == 0){
					button.setText("" + tr);
					button.setBackground(Color.LIGHT_GRAY);
				}

				else{
					Cell cell = table.cellAt(tr, tc);

					if(cell.isEmpty())
						button.setText("0");
					else{
						StringBuilder stringBuilder = new StringBuilder();

						if(cell.didEnter())
							stringBuilder.append("Y,");
						else
							stringBuilder.append("N,");

						stringBuilder.append('(');
						stringBuilder.append(cell.getProvenanceRow());
						stringBuilder.append(',');
						stringBuilder.append(cell.getProvenanceColumn());
						stringBuilder.append("),");
						stringBuilder.append(cell.getAcumulatedProfit());

						button.setText(stringBuilder.toString());

						if(cell.isMarked())
							switch(cell.getMark()){
								case 0: button.setBackground(Color.YELLOW); break;
								case 1: button.setBackground(Color.GREEN); break;
								case 2: button.setBackground(Color.BLUE); break;
								case 3: button.setBackground(Color.RED); break;
								case 4: button.setBackground(Color.ORANGE); break;
								case 5: button.setBackground(Color.WHITE); break;
							}
					}
				}

				panel.add(button);
			}

		setContentPane(panel);
	}
}