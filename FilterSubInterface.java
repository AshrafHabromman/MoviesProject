import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FilterSubInterface extends JFrame{
	
	JLabel c = new JLabel("Filter based on ?");
	
	String [] arrayOfStrings = {"Movie Name", "Director", "Year", "Duration"}; 
	
	JComboBox chose = new JComboBox(arrayOfStrings);
	
	JButton filterButton = new JButton("Filter");
	
	JTextArea filterTextArea= new JTextArea();
	
	JPanel atNorth  = new JPanel();
	
	JTextField userText = new JTextField(10);
	
	String userSelection;
	
	FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
	
	FilterSubInterface(){
		
		super("Filter");
		//setLayout(new FlowLayout());
		filterTextArea.setEditable(false);
		
		atNorth.setLayout(layout);
		
		atNorth.add(c);
		atNorth.add(chose);
		atNorth.add(userText);
		atNorth.add(filterButton);
		add(atNorth,BorderLayout.NORTH);
		add(filterTextArea, BorderLayout.CENTER);
		
		setSize(700, 250);
		//setVisible(true);
		
		chose.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					userSelection = arrayOfStrings[chose.getSelectedIndex()];
					//System.out.println(userSelection);
					
				}
		
			}
		});
		
		
		
	}
	
	public String getUserTypeSelection() {
		return userSelection;
	}
	
	
	public String getTextThatUserEntered() {
		return userText.getText();
	}
	
//	public static void main(String []g) {
//		FilterSubInterface ss = new FilterSubInterface();
//		ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//	}
}


