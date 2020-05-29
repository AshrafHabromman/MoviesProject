import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

public class MainInterface extends JFrame  {

	
	JButton readFromFile = new JButton("Read from file");
	JButton selectAll = new JButton("Select all");
	JButton selectSeen = new JButton("Select seen");
	JButton selectUnseen = new JButton("Select unseen");
	JButton markSeen = new JButton("Mark seen");
	JButton markUnseen = new JButton("Mark unseen");
	JButton addMovie = new JButton ("Add movie");
	JButton deletMovie = new JButton("Delet Movie");
	JButton editMovie = new JButton("Edit Movie");
	JButton filter = new JButton("Filter");
	
	JPanel buttons = new JPanel();
	
//	JPanel paper = new JPanel();
	
	SubInterface addInterface = new SubInterface("Add Movie",0);
	
	SubInterface editInterface = new SubInterface("Edit Movie",1);
	
	FileHandler functions = new FileHandler();
	
	JTextArea mainTextArea = new JTextArea();
	
	FilterSubInterface filterInterface = new FilterSubInterface();
	
	Movie movieBeforEditing ;
	
	public MainInterface() {
		
		super("Movies Management");
		
		buttons.add(readFromFile);
		buttons.add(selectAll);
		buttons.add(selectSeen);
		buttons.add(selectUnseen);
		buttons.add(markSeen);
		buttons.add(markUnseen);
		buttons.add(addMovie);
		buttons.add(deletMovie);
		buttons.add(editMovie);
		buttons.add(filter);
		
	    add(buttons,BorderLayout.NORTH);
		add(mainTextArea, BorderLayout.CENTER);
		mainTextArea.setEditable(false);
		
		
		readFromFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				functions.openFile();
			}
		});
		
		
		selectAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				printMovies(functions.selectAllMovies(),mainTextArea);
				
			}
		});
		
		
		selectSeen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    printMovies(functions.selectSeenMovies(),mainTextArea);
				
			}
		});
		

		selectUnseen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
            	printMovies(functions.selectUnseenMovies(),mainTextArea);
				
			}
		});
		
		
		markSeen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String selectedText = mainTextArea.getSelectedText();
					String []componentOfMovie = new String[5];
					componentOfMovie = selectedText.split("\t");
					ArrayList<Movie> unSM = functions.selectUnseenMovies();
//					for (String t : componentOfMovie)
//						System.out.println(t);
					
					if(componentOfMovie[4].equals("true"))
						JOptionPane.showMessageDialog(MainInterface.this, "It's ture -_- ", "Warning", JOptionPane.WARNING_MESSAGE);
					
					else {
						int index;
						for ( index=0; index<unSM.size(); index++) {
							if (componentOfMovie[0].equals(unSM.get(index).getName()))
								break;
						}
						functions.markSeen(unSM.get(index));
						//functions.editMovie(unSM.get(index), unSM.get(index));
						//
						printMovies(functions.selectAllMovies(),mainTextArea);
					}
					
				}
				catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(MainInterface.this, "Please select the movie that you want to mark as seen movie", "NullPointerException", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		markUnseen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String selectedText = mainTextArea.getSelectedText();
					String []componentOfMovie = new String[5];
					componentOfMovie = selectedText.split("\t");
					ArrayList<Movie> unSM = functions.selectSeenMovies();
					for (String t : componentOfMovie)
						System.out.println(t);
					
					if(componentOfMovie[4].equals("false"))
						JOptionPane.showMessageDialog(MainInterface.this, "It's false -_- ", "Warning", JOptionPane.WARNING_MESSAGE);
					
					else {
						int index;
						for ( index=0; index<unSM.size(); index++) {
							if (componentOfMovie[0].equals(unSM.get(index).getName()))
								break;
						}
						
						functions.markUnseen(unSM.get(index));
						
						printMovies(functions.selectAllMovies(),mainTextArea);
					}
					
				
				}
				catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(MainInterface.this, "Please select the movie that you want to mark as un seen movie", "NullPointerException", JOptionPane.WARNING_MESSAGE);

				}
		
			}
		});
		
		
		
		addMovie.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				addInterface.setName("name");
				addInterface.setDirector("director");
				addInterface.setYear("year");
				addInterface.setDuration("0");
				
				addInterface.setVisible(true);
				
			}
		});
		
		
		addInterface.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					functions.addMovie(new Movie(addInterface.getName(), addInterface.getDirector(), addInterface.getYear(), addInterface.getDuration(), addInterface.isSeen()));
					addInterface.setVisible(false);
					printMovies(functions.selectAllMovies(),mainTextArea);
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(MainInterface.this, "Please dont't add text in duration text field", "NumberFormatException", JOptionPane.WARNING_MESSAGE);
				}
				
				
				
			}
			
				
			
		});
		
		editMovie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					
					editInterface.setVisible(true);
					
					String selectedText = mainTextArea.getSelectedText();
					String []componentOfMovie = new String[5];
					componentOfMovie = selectedText.split("\t");
					editInterface.setName(componentOfMovie[0]);
					editInterface.setDirector(componentOfMovie[1]);
					editInterface.setYear(componentOfMovie[2]);
					editInterface.setDuration(componentOfMovie[3]);
					
					
					if(componentOfMovie[4].equals("true"))
						editInterface.setSeen(true);
					else editInterface.setSeen(false);
					
					int j = functions.selectAllMovies().size();
					int index;
					
					for (index=0; index<j; index++) 
						if(functions.selectAllMovies().get(index).getName().equals(componentOfMovie[0]))
							break;
					
					setMovieBeforEditing(functions.selectAllMovies().get(index));
				}
				
				catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(MainInterface.this, "Please select a movie to edit .", "NullPointerException", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		});
		
		editInterface.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Movie movieBeforEditing = getMovieBeforEditing();
					Movie movieAfterEditing = new Movie(editInterface.getName(), editInterface.getDirector(), editInterface.getYear(), editInterface.getDuration(), editInterface.isSeen());
					functions.editMovie(movieAfterEditing, movieBeforEditing);
					
					editInterface.setVisible(false);
					
					printMovies(functions.selectAllMovies(),mainTextArea);
					
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(MainInterface.this, "Please dont't add text in duration text field", "NumberFormatException", JOptionPane.WARNING_MESSAGE);
				}
	
			}
		});

		
		mainTextArea.addMouseListener(new MouseAdapter() {
			
		    public void mouseClicked(MouseEvent evt) {
		    	
				  int pos = mainTextArea.getCaretPosition();
	              int start = 0;
	              try {
	                  start = Utilities.getRowStart(mainTextArea, pos);
	              } catch (BadLocationException e1) {
	                  // TODO Auto-generated catch block
	                  e1.printStackTrace();
	              }
	              int end = 0;
	              try {
	                  end = Utilities.getRowEnd(mainTextArea, pos);
	              } catch (BadLocationException e1) {
	                  // TODO Auto-generated catch block
	                  e1.printStackTrace();
	              }
	              mainTextArea.setSelectionStart(start);
	              mainTextArea.setSelectionEnd(end);
	             //String S= t.getSelectedText();
	
		    }
		});
		
		
		deletMovie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String selectedText = mainTextArea.getSelectedText();
					String componentOfMovie[] = selectedText.split("\t");
					ArrayList<Movie> allM = functions.selectAllMovies();
					int index;
					for(index=0; index<allM.size(); index++)
						if(allM.get(index).getName().equals(componentOfMovie[0]))
							break;
					
					functions.delMovie(allM.get(index));
					
					printMovies(functions.selectAllMovies(),mainTextArea);
				
				}
				catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(MainInterface.this, "Please select a movie to delet. ", "NullPointerException", JOptionPane.WARNING_MESSAGE);
				}
			
			
			}
		});
		
		
		filter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				filterInterface.setVisible(true);
			}
		});
		
		
		filterInterface.filterButton.addActionListener(new ActionListener() {
			
			@Override
			
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						ArrayList<Movie> filteredMovie = new ArrayList<Movie>();
						
						if(filterInterface.getUserTypeSelection().equals("Movie Name"))
							filteredMovie = functions.filterMoviesBasedOnName(filterInterface.getTextThatUserEntered());
						
						else if(filterInterface.getUserTypeSelection().equals("Director"))
							filteredMovie = functions.filterMoviesBasedOnDirector(filterInterface.getTextThatUserEntered());
						
						else if(filterInterface.getUserTypeSelection().equals("Year"))
							filteredMovie = functions.filterMoviesBasedOnYear(filterInterface.getTextThatUserEntered());
						
						else if(filterInterface.getUserTypeSelection().equals("Duration"))
							filteredMovie = functions.filterMoviesBasedOnDuration(Integer.parseInt(filterInterface.getTextThatUserEntered()));
						
						
						if (filteredMovie.isEmpty()) {
							filterInterface.filterTextArea.setText("No Data Exist. ");
						}
						else
							printMovies(filteredMovie, filterInterface.filterTextArea);
						
					}
					catch(NullPointerException ex) {
						JOptionPane.showMessageDialog(MainInterface.this ,"Please Enter Correct input. ", "NullPointerException", JOptionPane.WARNING_MESSAGE);
					}
					
					catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(MainInterface.this ,"Please Enter Correct input, Don't enter text in duration field.  ", "NumberFormatException", JOptionPane.WARNING_MESSAGE);	
					}
				
		
			}	
	
		 
	
			
		
		});

		
		setSize(1300, 400);
		setResizable(false);
		setVisible(true);
	
	}
	
	
	public void printMovies(ArrayList<Movie> moviesToPrint, JTextArea tA) {
		
		    tA.setText("");
			int j = moviesToPrint.size();
//			ArrayList<Movie> movies = functions.selectAllMovies();
			for (int i=0 ; i<j ;i++) {
				
				tA.append(moviesToPrint.get(i).toString());
			}
			
	}
	
	private void setMovieBeforEditing(Movie m) {
		this.movieBeforEditing = m;
	}
	
	private Movie getMovieBeforEditing() {
		return this.movieBeforEditing;
		
	}

	
	
	
	public static void main(String []g) {
		MainInterface i = new MainInterface();
		i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
