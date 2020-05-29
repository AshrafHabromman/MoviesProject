import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.print.DocFlavor.URL;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SubInterface extends JFrame {
	
	JLabel nameL = new JLabel("Name");
	JLabel diractorL = new JLabel("Director");
	JLabel yearL = new JLabel("Year");
	JLabel durationL = new JLabel("Duration");
	
	JTextField nameT = new JTextField(10);
	JTextField directorT = new JTextField(10);
	JTextField yearT = new JTextField(10);
	JTextField durationT = new JTextField("0", 10);
	
	JCheckBox seen = new JCheckBox("seen");
	
	JButton ok = new JButton("Ok");
	
	JPanel atNorth = new JPanel();
	
	Movie newMovie ;
	
	boolean isSeen = false;
	
	boolean isOkclicked=false;
	
	Integer i ;//if 0 it means add movie if 1 edit movie.
	
	public SubInterface(String title, int i) {
		super(title);
		this.i=i;
		atNorth.add(nameL);
		atNorth.add(nameT);
		atNorth.add(diractorL);
		atNorth.add(directorT);
		atNorth.add(yearL);
		atNorth.add(yearT);
		atNorth.add(durationL);
		atNorth.add(durationT);
		atNorth.add(seen);
		atNorth.add(ok);
		
			
		add(atNorth, BorderLayout.NORTH);
		
		//setVisible(true);
		setResizable(false);
		setSize(900, 100);
		

		
		seen.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent t) {
				// TODO Auto-generated method stub
				if (seen.isSelected()) {
					isSeen =true;
				}
			}
		});
		
	}
	
	public String getName() {
		return nameT.getText();
	}
	
	public void setName(String name) {
		nameT.setText(name);
	}
	
	public String getYear() {
		return yearT.getText();
	}
	
	
	public void setYear(String year) {
		yearT.setText(year);
	}
	
	public String getDirector(){
		return directorT.getText();
	}
	
	public void setDirector(String director) {
		directorT.setText(director);
	}
	
	public int getDuration() {
		return Integer.parseInt(durationT.getText());
		
	}
	
	public void setDuration(String duration) {
		durationT.setText(""+duration);
	}
	
	
	public boolean isSeen() {
		return this.isSeen;
	}
		
	
	public void setSeen(boolean isSeen) {
		this.seen.setSelected(isSeen);
		this.isSeen = isSeen;
	}
	
	public Movie getNewMovie() {
		return newMovie;
	}
		
	
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//
//		switch(this.i){
//		case 0:
//			try {
//				newMovie = new Movie(getName(), getDirector(), getYear(), getDuration(), isSeen());
//				isOkclicked =true;
//		
//				
//			}
//			catch(NumberFormatException ex) {
//				JOptionPane.showMessageDialog(null, "Please don't enter a string in duration text field","NumberFormatException", JOptionPane.WARNING_MESSAGE);
//			}
//			break;	
//		case 1:
//	
//			newMovie = new Movie(getName(), getDirector(), getYear(), getDuration(), isSeen());
//			setVisible(false);
//			
//			
//			
//		}
//		
//	}
//	
	
	
//	
//	public static void main(String []g) {
//		SubInterface s= new SubInterface("Select",0);
//		System.out.println(s.getName());
//	}
//		
	


}
