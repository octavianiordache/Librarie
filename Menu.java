package bookstore;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//import org.junit.jupiter.api.Assertions;

//import lab13.DBUtil;

//import lab10.GUI;

/**
 * @author Iordache Constantin Octavian
 * @since 2022-02-06
 *@version 1.0
 */
public class Menu {

	/**
	 * @param args argumentele preluate de pe linia de comanda
	 * @throws ClassNotFoundException Exceptie de tipul ClassNotFoundException
	 * @throws IOException Exceptie de tipul IOException
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Book x= new Book("ion", "Liviu Rebreanu", 2000, 15.5, 100);
		//System.out.println(x);
		
		Book a= new Book("poezii", "Eminescu", 2000, 15.5, 100);
		//System.out.println(a);
		
		WritingTool b= new WritingTool("stilou", 50, 5);
		//Client z= new Client("Ion Popescu", 1970, "Sibiu", "0798654321", "popescu.ion@gmail.com");
		//System.out.println(z);
		
		x.setPrice(16.9);
		//System.out.println(x);
		//Book copy_book=(Book)a.clone();
		//copy_book=(Book)a.clone();
		//copy_book.setNoBooks(1);
		//System.out.println(copy_book);
		//System.out.println(a);
		Cart y= new Cart();
		Book x_copy= new Book(x.getTitle(), x.getAuthor(), x.getYear(), x.getPrice(), x.getNoBooks());
		x_copy.setNoBooks(1);
		x.setNoBooks(x.getNoBooks()-1);
		//System.out.println(x_copy);
		//System.out.println(x);
		y.addELement(x_copy);
		//y.addELement(a);
		//y.addELement(b);
		System.out.println(y);
		
		File file = new File("bookstore.ser");
		GUI gui = new GUI(file);
		gui.setVisible(true);
		gui.setLocationRelativeTo(null);
		
		Cart c= new Cart();
		Book a2=new Book("x","y",2000,15.1,50);
		Book b2=new Book("x","y",2000,20,50);
		c.addELement(a2);
		c.addELement(b2);
		//System.out.println(c.sum());
		//Assertions.assertEquals(
				//System.out.println(15.1*50+20*50);
				
		/**
		 * Conexiunea la baza de date
		 */
		Connection conn = DBUtil.getConnection();
		
		try {
			Statement st= conn.createStatement();
			//st.execute("CREATE TABLE CARTI (TITLU VARCHAR(50), AUTOR VARCHAR(25), PRET DOUBLE, NUMAR INT)");
			//st.execute("ALTER TABLE CARTI ADD AN INT");
			//st.execute("CREATE TABLE MANUALE (MATERIE VARCHAR(50), EDITURA VARCHAR(50), PRET DOUBLE, NUMAR INT, AN INT)");
			//st.execute("CREATE TABLE INSTRUMENTE(NUME VARCHAR(50), PRET DOUBLE, NUMAR INT)");
			//st.execute("INSERT INTO CARTI VALUES('Ion','Liviu Rebreanu', 15.5, 100, 1920)");
			//st.execute("INSERT INTO CARTI VALUES('Moara cu noroc','Ioan Slavici', 18.9, 110, 1881)");
			//st.execute("INSERT INTO CARTI VALUES('Basme','Fratii Grimm', 28.2, 300, 2000)");
			//st.execute("INSERT INTO CARTI VALUES('Supermintea','Dave Asprey', 49.8, 60, 2021)");
			//st.execute("INSERT INTO CARTI VALUES('Dependenti de mancare','Michael Moss', 39.95, 45, 2022)");
			
			//st.execute("INSERT INTO MANUALE VALUES('Limba romana','BOOKLET', 33.2, 300, 2020)");
			//st.execute("INSERT INTO MANUALE VALUES('Matematica','Libris', 30.2, 200, 2019)");
			//st.execute("INSERT INTO MANUALE VALUES('Istorie','CD PRESS', 18.5, 150, 2001)");
			//st.execute("INSERT INTO MANUALE VALUES('Fizica','Paralela 45', 20.5, 250, 2016)");
			//st.execute("INSERT INTO MANUALE VALUES('Geografie','Art Klett', 19.9, 210, 2008)");
			
			//st.execute("INSERT INTO INSTRUMENTE VALUES('Stilou', 25.0, 100)");
			//st.execute("INSERT INTO INSTRUMENTE VALUES('Creion', 1.9, 1000)");
			//st.execute("INSERT INTO INSTRUMENTE VALUES('Rigla', 4.8, 500)");
			//st.execute("INSERT INTO INSTRUMENTE VALUES('Ascutitoare', 9.9, 210)");
			//st.execute("INSERT INTO INSTRUMENTE VALUES('Radiera', 3.5, 180)");
			
			conn.commit();
			//st.executeQuerry(null)
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}