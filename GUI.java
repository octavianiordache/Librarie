package bookstore;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GUI extends JFrame{
	private static final LayoutManager BoxLayOut = null;
	JLabel titleLabel;
	JTextField titleTextField;

	JTextField titlefield= new JTextField(32);
	JTextField authorfield= new JTextField(32);
	JTextField yearfield= new JTextField(4);
	JTextField pricefield= new JTextField(6);
	JTextField nofield= new JTextField(6);
	JTextField no_buyfield= new JTextField(3);
	
	JTextField subjectfield= new JTextField(32);
	JTextField editurefield= new JTextField(32);
	JTextField yearfield2= new JTextField(4);
	JTextField pricefield2= new JTextField(6);
	JTextField nofield2= new JTextField(6);
	JTextField no_buyfield2= new JTextField(3);
	
	JTextField namefield= new JTextField(32);
	JTextField pricefield3= new JTextField(6);
	JTextField nofield3= new JTextField(6);
	JTextField no_buyfield3= new JTextField(6);	
	
	JLabel lengthLabel;
	JSpinner lengthSpinner;

	/**
	 * butonul pentru carti
	 */
	JButton bookButton;
	
	/**
	 * butonul pentru manuale
	 */
	JButton manualButton;
	
	/**
	 * butonul pentru instrumente
	 */
	JButton instrumentsButton;
	
	/**
	 * butonul pentru cosul de cumparaturi
	 */
	JButton cartButton;
	JButton deleteButton;
	
	/**
	 * lista de carti
	 */
	List <Book> books;
	
	/**
	 * lista de manuale
	 */
	List<Manual> manuals;
	
	/**
	 * lista de instrumente de scris
	 */
	List<WritingTool> instruments;
	
	/**
	 * indicator pentru pozitia curenta
	 */
	int currentPosition;
	
	/**
	 * Cosul de cumparaturi
	 */
	Cart c= new Cart();
	
	/**
	 * conexiunea la baza de date
	 */
	Connection conn= DBUtil.getConnection();
	
	
	/**
	 * Metoda pentru schimbarea pozitiei curente
	 * @param newPosition preia noua pozitie si o seteaza
	 */
	private void changeCurrentItem(int newPosition) {
			currentPosition = newPosition;
	}
	
	/**
	 * Metoda pentru initilizarea listei de carti
	 * Aici se preiau informatiile despre cartile aflate in baza de date
	 * din tabela carti
	 */
	private void initializeBooksList()
	{
		currentPosition=0;
		this.books= new ArrayList<Book>();
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT titlu, autor, pret, numar, an FROM carti");
			while (rs.next()) {
				books.add(new Book(rs.getString("titlu"), rs.getString("autor"), rs.getInt("an"), rs.getDouble("pret"), rs.getInt("numar")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(books);
		
	}
	
	/**
	 * Metoda pentru a putea naviga prin lista de carti
	 * Prin aceasta metoda se seteaza campurile corespunzatoare din 
	 * interefata grafica
	 * @param newPosition indica noua pozitie pe care ne aflam in lista de carti
	 */
	private void changeCurrentBook(int newPosition) {
			currentPosition = newPosition;
			
			titlefield.setText(books.get(currentPosition).title);
			authorfield.setText(books.get(currentPosition).author);
			pricefield.setText(String.valueOf(books.get(currentPosition).price));
			nofield.setText(String.valueOf(books.get(currentPosition).noBooks));
			yearfield.setText(String.valueOf(books.get(currentPosition).year));	
	}
	
	/**
	 * Metoda pentru initilizarea listei de manuale
	 * Aici se preiau informatiile despre manualele aflate in baza de date
	 * din tabela manuale
	 */
	private void initializeManualsList()
	{
		currentPosition=0;
		this.manuals= new ArrayList<Manual>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT materie, editura, pret, numar, an FROM manuale");
			while (rs.next()) {
				manuals.add(new Manual(rs.getString("materie"), rs.getString("editura"), rs.getInt("an"), rs.getDouble("pret"), rs.getInt("numar")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(manuals);
	}
	
	/**
	 * Metoda pentru a putea naviga prin lista de manuale
	 * Prin aceasta metoda se seteaza campurile corespunzatoare din 
	 * interefata grafica
	 * @param newPosition indica noua pozitie pe care ne aflam in lista de manule
	 */
	private void changeCurrentManual(int newPosition) {
			currentPosition = newPosition;
			
			subjectfield.setText(manuals.get(currentPosition).subject);
			editurefield.setText(manuals.get(currentPosition).editure);
			pricefield2.setText(String.valueOf(manuals.get(currentPosition).price));
			nofield2.setText(String.valueOf(manuals.get(currentPosition).noManuals));
			yearfield2.setText(String.valueOf(manuals.get(currentPosition).year));
	}
	
	
	/**
	 * Metoda pentru initilizarea listei de instrumente
	 * Aici se preiau informatiile despre instrumentele de scris aflate 
	 * in baza de date din tabela instrumente
	 */
	private void initializeInstrumentsList()
	{
		currentPosition=0;
		this.instruments= new ArrayList<WritingTool>();
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT nume, pret, numar FROM instrumente");
			while (rs.next()) {
				instruments.add(new WritingTool(rs.getString("nume"), rs.getDouble("pret"), rs.getInt("numar")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(instruments);
		
	}
	
	
	/**
	 * Metoda pentru a putea naviga prin lista de instrumente
	 * Prin aceasta metoda se seteaza campurile corespunzatoare din 
	 * interefata grafica
	 * @param newPosition indica noua pozitie pe care ne aflam in lista de instrumente
	 */
	private void changeCurrentInstrument(int newPosition) {
			currentPosition = newPosition;
			
			namefield.setText(instruments.get(currentPosition).name);
			pricefield3.setText(String.valueOf(instruments.get(currentPosition).price));
			nofield3.setText(String.valueOf(instruments.get(currentPosition).noTools));
	}
	
	/**
	 * Fereastra principala
	 * Contine Butoanele: carti, manuale, instrumente, cos de cumparaturi
	 */
	private void MainPanel()
	{
		this.bookButton= new JButton("Carti");
		this.bookButton.setPreferredSize(new Dimension(200, 30));
		
		this.manualButton= new JButton("Manuale");
		this.manualButton.setPreferredSize(new Dimension(200, 30));
		
		this.instrumentsButton= new JButton("Instrumente");
		this.instrumentsButton.setPreferredSize(new Dimension(200, 30));
		
		this.cartButton=new JButton("Cos de cumparaturi");
		this.cartButton.setPreferredSize(new Dimension(200, 30));
		
		JPanel main= new JPanel(new FlowLayout());
		main.setPreferredSize(new Dimension(210, 210));
		
		main.add(this.bookButton);
		main.add(this.manualButton);
		main.add(this.instrumentsButton);
		main.add(this.cartButton);
		
		this.add(main);
		
		
		this.bookButton.addActionListener(new ActionListener() {
			private JButton firstButton1;
			private JButton previousButton1;
			private JButton adButton1;
			private JButton nextButton1;
			private JButton lastButton1;

			/**
			 * @param e evenimentul care se produce
			 */
			public void actionPerformed(ActionEvent e) {
				JFrame bookFrame = new JFrame("Books");
				bookFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
				bookFrame.setSize(350, 380);
				bookFrame.setResizable(false);
				bookFrame.setLocationRelativeTo(null);
				bookFrame.setVisible(true);
				bookFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

				JLabel titleLabel = new JLabel("Titlu:");
				JLabel authorLabel= new JLabel("Autor:");
				JLabel yearLabel= new JLabel("An:");
				JLabel priceLabel= new JLabel("Pret:");
				JLabel noLabel= new JLabel("Nr Bucati:");
				JLabel no_buyLabel= new JLabel("Cate bucati doresti sa cumperi:");
				
				bookFrame.add(titleLabel);
				bookFrame.add(titlefield);
				bookFrame.add(authorLabel);
				bookFrame.add(authorfield);
				bookFrame.add(yearLabel);
				bookFrame.add(yearfield);
				bookFrame.add(priceLabel);
				bookFrame.add(pricefield);
				bookFrame.add(noLabel);
				bookFrame.add(nofield);
				bookFrame.add(no_buyLabel);
				bookFrame.add(no_buyfield);
				
				this.adButton1= new JButton("Adauga");
				((Component) this.adButton1).setPreferredSize(new Dimension(200, 30));
				
				this.firstButton1= new JButton("Prima");
				this.firstButton1.setPreferredSize(new Dimension(200, 30));
				
				this.previousButton1= new JButton("Inapoi");
				this.previousButton1.setPreferredSize(new Dimension(200, 30));
				
				this.nextButton1= new JButton("Urmatoarea");
				this.nextButton1.setPreferredSize(new Dimension(200, 30));
				
				this.lastButton1= new JButton("Ultima");
				this.lastButton1.setPreferredSize(new Dimension(200, 30));
				
				this.adButton1= new JButton("Adauga in cos");
				((Component) this.adButton1).setPreferredSize(new Dimension(200, 30));
				
				bookFrame.add(firstButton1);
				bookFrame.add(previousButton1);
				bookFrame.add(nextButton1);
				bookFrame.add(lastButton1);
				bookFrame.add((Component) adButton1);
				initializeBooksList();
				
			/**
			 * ActionListener pentru butonul "urmatorul"
			 * Merge la urmatorul obiect din lista
			 */
				this.nextButton1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentBook((currentPosition == books.size()-1) ? 0 : currentPosition + 1);
						
					}
					
					
				});
				
				/**
				 * ActionListener pentru butonul "anterior"
				 * Merge la obiectul anterior
				 */
				this.previousButton1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentBook((currentPosition == 0) ? books.size()-1 : currentPosition - 1);
						
					}
					
					
				});
				
				/**
				 * ActionListener pentru butonul "primul"
				 * Merge la primul obiect din lista
				 */
				this.firstButton1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentBook(0);
						
					}
					
					
				});
				
				/**
				 * ActionListener pentru butonul "ultimul"
				 * Merge la ultimul obiect din lista 
				 */
				this.lastButton1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentBook(books.size()-1);
						
					}
					
					
				});
				
				/**
				 * ActionListener pentru butonul "adauga"
				 * Adauga obiectul in cosul de cumparaturi
				 */
				this.adButton1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String titlu1=titlefield.getText();
						int nrT=Integer.valueOf(nofield.getText());
						int nrB=Integer.valueOf(no_buyfield.getText());
						int nrR=nrT-nrB;
						Book p=new Book(titlefield.getText(), authorfield.getText(), Integer.valueOf(yearfield.getText()), Double.parseDouble(pricefield.getText()), Integer.valueOf(no_buyfield.getText()));
						try {
							Statement st=conn.createStatement();
							st.executeUpdate("UPDATE carti SET numar = "+nrR +" WHERE titlu = '" +  titlu1+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						c.addELement(p); 
					}
					
					
				});
				
				
			}
			});

		this.manualButton.addActionListener(new ActionListener() {
			private JButton firstButton2;
			private JButton previousButton2;
			private JButton adButton2;
			private JButton nextButton2;
			private JButton lastButton2;
			
			public void actionPerformed(ActionEvent e) {
				JFrame manualFrame = new JFrame("Manuals");
				manualFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
				manualFrame.setSize(350, 380);
				manualFrame.setResizable(false);
				manualFrame.setLocationRelativeTo(null);
				manualFrame.setVisible(true);
				manualFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

				JLabel subjectLabel = new JLabel("Materie:");
				JLabel editureLabel= new JLabel("Editura:");
				JLabel yearLabel= new JLabel("An:");
				JLabel priceLabel= new JLabel("Pret:");
				JLabel noLabel= new JLabel("Nr Bucati:");
				JLabel no_buyLabel= new JLabel("Cate bucati doresti sa cumperi:");
				
				
				
				manualFrame.add(subjectLabel);
				manualFrame.add(subjectfield);
				manualFrame.add(editureLabel);
				manualFrame.add(editurefield);
				manualFrame.add(yearLabel);
				manualFrame.add(yearfield2);
				manualFrame.add(priceLabel);
				manualFrame.add(pricefield2);
				manualFrame.add(noLabel);
				manualFrame.add(nofield2);
				manualFrame.add(no_buyLabel);
				manualFrame.add(no_buyfield2);
				
				this.adButton2= new JButton("Adauga");
				((Component) this.adButton2).setPreferredSize(new Dimension(200, 30));
				
				this.firstButton2= new JButton("Prima");
				this.firstButton2.setPreferredSize(new Dimension(200, 30));
				
				this.previousButton2= new JButton("Inapoi");
				this.previousButton2.setPreferredSize(new Dimension(200, 30));
				
				this.nextButton2= new JButton("Urmatoarea");
				this.nextButton2.setPreferredSize(new Dimension(200, 30));
				
				this.lastButton2= new JButton("Ultima");
				this.lastButton2.setPreferredSize(new Dimension(200, 30));
				
				this.adButton2= new JButton("Adauga in cos");
				((Component) this.adButton2).setPreferredSize(new Dimension(200, 30));
				
				manualFrame.add(firstButton2);
				manualFrame.add(previousButton2);
				manualFrame.add(nextButton2);
				manualFrame.add(lastButton2);
				manualFrame.add((Component) adButton2);
				
				initializeManualsList();
				this.nextButton2.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentManual((currentPosition == manuals.size()-1) ? 0 : currentPosition + 1);
						
					}
					
					
				});
				
				this.previousButton2.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentManual((currentPosition == 0) ? manuals.size()-1 : currentPosition - 1);
						
					}
					
					
				});
				
				this.firstButton2.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentManual(0);
						
					}
					
					
				});
				
				this.lastButton2.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentManual(manuals.size()-1);
						
					}
					
					
				});
				
				this.adButton2.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						Manual p=new Manual(subjectfield.getText(), editurefield.getText(), Integer.valueOf(yearfield2.getText()), Double.parseDouble(pricefield2.getText()), Integer.valueOf(no_buyfield2.getText()));
						
						String subject1=subjectfield.getText();
						int nrT=Integer.valueOf(nofield2.getText());
						int nrB=Integer.valueOf(no_buyfield2.getText());
						int nrR=nrT-nrB;

						try {
							Statement st=conn.createStatement();
							st.executeUpdate("UPDATE manuale SET numar = "+nrR +" WHERE materie = '" +  subject1+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						c.addELement(p); 
					}
					
					
				});
				
				
			}
		});

		this.instrumentsButton.addActionListener(new ActionListener() {
			private JButton firstButton3;
			private JButton previousButton3;
			private JButton adButton3;
			private JButton nextButton3;
			private JButton lastButton3;

			public void actionPerformed(ActionEvent e) {
				JFrame instrumentsFrame = new JFrame("Instruments");
				instrumentsFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
				instrumentsFrame.setSize(350, 340);
				instrumentsFrame.setResizable(false);
				instrumentsFrame.setLocationRelativeTo(null);
				instrumentsFrame.setVisible(true);
				instrumentsFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

				JLabel nameLabel = new JLabel("Nume:");
				JLabel priceLabel= new JLabel("Pret:");
				JLabel noLabel= new JLabel("Nr Bucati:");
				JLabel no_buyLabel= new JLabel("Cate bucati doresti sa cumperi:");			
			
				instrumentsFrame.add(nameLabel);
				instrumentsFrame.add(namefield);
				instrumentsFrame.add(priceLabel);
				instrumentsFrame.add(pricefield3);
				instrumentsFrame.add(noLabel);
				instrumentsFrame.add(nofield3);
				instrumentsFrame.add(no_buyLabel);
				instrumentsFrame.add(no_buyfield3);
				
				this.adButton3= new JButton("Adauga");
				((Component) this.adButton3).setPreferredSize(new Dimension(200, 30));
				
				this.firstButton3= new JButton("Primul");
				this.firstButton3.setPreferredSize(new Dimension(200, 30));
				
				this.previousButton3= new JButton("Inapoi");
				this.previousButton3.setPreferredSize(new Dimension(200, 30));
				
				this.nextButton3= new JButton("Urmatoarul");
				this.nextButton3.setPreferredSize(new Dimension(200, 30));
				
				this.lastButton3= new JButton("Ultimul");
				this.lastButton3.setPreferredSize(new Dimension(200, 30));
				
				this.adButton3= new JButton("Adauga in cos");
				((Component) this.adButton3).setPreferredSize(new Dimension(200, 30));
				
				instrumentsFrame.add(firstButton3);
				instrumentsFrame.add(previousButton3);
				instrumentsFrame.add(nextButton3);
				instrumentsFrame.add(lastButton3);
				instrumentsFrame.add((Component) adButton3);
				
				initializeInstrumentsList();
				this.nextButton3.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentInstrument((currentPosition == instruments.size()-1) ? 0 : currentPosition + 1);
						
					}
					
					
				});
				
				this.previousButton3.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentInstrument((currentPosition == 0) ? instruments.size()-1 : currentPosition - 1);
						
					}
					
					
				});
				
				this.firstButton3.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentInstrument(0);
						
					}
					
					
				});
				
				this.lastButton3.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						System.out.println("ok");
						changeCurrentInstrument(instruments.size()-1);
						
					}
					
					
				});
				
				this.adButton3.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						System.out.println("ok");
						WritingTool p=new WritingTool(namefield.getText(), Double.parseDouble(pricefield3.getText()), Integer.valueOf(no_buyfield3.getText()));
						
						String nume1=namefield.getText();
						int nrT=Integer.valueOf(nofield3.getText());
						int nrB=Integer.valueOf(no_buyfield3.getText());
						int nrR=nrT-nrB;
						try {
							Statement st=conn.createStatement();
							st.executeUpdate("UPDATE instrumente SET numar = "+nrR +" WHERE nume = '" +  nume1+"'");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						c.addELement(p); 
					}
					
					
				});
			}
		});

		this.cartButton.addActionListener(new ActionListener() {
			private JButton firstButton4;
			private JButton previousButton4;
			private JButton adButton4;
			private JButton nextButton4;
			private JButton lastButton4;

			public void actionPerformed(ActionEvent e) {
				JFrame cartFrame = new JFrame("Cart");
				cartFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
				cartFrame.setSize(700, 300);
				cartFrame.setResizable(false);
				cartFrame.setLocationRelativeTo(null);
				cartFrame.setVisible(true);
				cartFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

				JLabel nameLabel = new JLabel("Nume:");
				JLabel priceLabel= new JLabel("Pret:");
				JLabel noLabel= new JLabel("Nr Bucati:");
				JLabel totalLabel= new JLabel("PRETUL TOTAL AL COMENZII:");
				
				JTextField namefield= new JTextField(32);
				JTextField pricefield= new JTextField(6);
				pricefield.setEditable(false);
				JTextField nofield= new JTextField(6);
				JTextField totalfield= new JTextField(6);
				JTextArea cartfield=new JTextArea(10,4 );
		
				cartfield.append(c.toString());
				cartFrame.add(cartfield);
				totalfield.setText(String.valueOf(c.sum()));
				
				cartFrame.add(totalLabel);
				cartFrame.add(totalfield);
				
				this.firstButton4= new JButton("Primul");
				this.firstButton4.setPreferredSize(new Dimension(200, 30));
				
				this.previousButton4= new JButton("Inapoi");
				this.previousButton4.setPreferredSize(new Dimension(200, 30));
				
				this.nextButton4= new JButton("Urmatoarul");
				this.nextButton4.setPreferredSize(new Dimension(200, 30));
				
				this.lastButton4= new JButton("Ultimul");
				this.lastButton4.setPreferredSize(new Dimension(200, 30));
				
				this.adButton4= new JButton("Cumpara ");
				((Component) this.adButton4).setPreferredSize(new Dimension(200, 30));
				
				cartFrame.add((Component) adButton4);
				
				this.nextButton4.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						System.out.println(c);
					}
					
					
				});
				
				this.previousButton4.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentItem((currentPosition == 0) ? instruments.size()-1 : currentPosition - 1);
						
					}
					
					
				});
				
				this.firstButton4.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentItem(0);
						
					}
					
					
				});
				
				this.lastButton4.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						changeCurrentItem(instruments.size()-1);
						
					}
					
					
				});
				
				this.adButton4.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						System.out.println("ok");
					}
					
					
				});
			}
		});

	}
	
	public GUI(File file) throws IOException, ClassNotFoundException {
		super("Bookstore");

		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setSize(240, 205);
		
		MainPanel();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

	}
}