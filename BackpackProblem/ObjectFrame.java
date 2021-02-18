import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class ObjectFrame extends JFrame{

	private StolenObject objectList[];
	private int objectCount, numberOfRows, numberOfColumns;

	public ObjectFrame(){
		super("Object List");
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = getSize();
		setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
		objectList = null;
		objectCount = -1;
		numberOfRows = -1;
		numberOfColumns = -1;
	}

	public ObjectFrame(StolenObject objectList[]){
		super("Object List");
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = getSize();
		setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
		this.objectList = objectList;
		objectCount = objectList.length;
		numberOfRows = -1;
		numberOfColumns = -1;
	}

	public void setObjectList(StolenObject objectList[]){
		this.objectList = objectList;
		objectCount = objectList.length;
	}

	public void build(){
		numberOfRows = objectCount;
		numberOfColumns = 3;

		JPanel panel = new JPanel(new GridLayout(numberOfRows + 1, numberOfColumns));

		panel.add(new JButton("Object"));
		panel.add(new JButton("Profit"));
		panel.add(new JButton("Weight"));

		for(int r = 0; r < objectCount; r++){
			panel.add(new JButton(objectList[r].getName()));
			panel.add(new JButton("" + objectList[r].getProfit()));
			panel.add(new JButton("" + objectList[r].getWeight()));
		}
		setContentPane(panel);
	}
}