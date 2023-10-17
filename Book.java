package bookstore;

public class Book implements Cloneable{
	/**
	 * Titlul cartii
	 * */
	String title;
	
	/**
	 * Autorul cartii
	 */
	String author;
	
	/**
	 * Anul aparitiei
	 */
	int year;
	
	/**
	 * Pretul cartii
	*/
	double price;
	
	/**
	 * Numarul de carti disponibile
	 */
	int noBooks;
	
	/**
	 * Constructor fara parametrii
	 */
	public Book(){}
	
	/**
	 * Constructor cu parametrii 
	 * @param title preia titlul cartii si il seteaza
	 * @param author preia autorul cartii si il seteaza
	 * @param year preia anul aparitiei cartii si il seteaza
	 * @param price preia pretul cartii si il seteaza
	 * @param noBooks preia numarul de carti si il seteaza
	 */
	public Book(String title, String author, int year, double price, int noBooks) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
		this.noBooks = noBooks;
	}


	/**
	 * @return returneaza titlul cartii
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title preia titlul si il seteaza
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return returneaza autorul cartii
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * @param author preia autorul si il seteaza
	 */
	public void setAuthor(String author) {
		this.author = author;
	}


	/**
	 * @return returneaza anul aparitiei
	 */
	public int getYear() {
		return year;
	}


	/**
	 * @param year preia anul aparitiei si il seteaza
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * @return returneaza pretul cartii
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price preia pretul cartii si il seteza
	 */
	public void setPrice(double price) {
		this.price = price;
	}


	/**
	 * @return returneaza numarul de carti
	 */
	public int getNoBooks() {
		return noBooks;
	}


	/**
	 * @param noBooks preia numarul de carti si il seteaza
	 */
	public void setNoBooks(int noBooks) {
		this.noBooks = noBooks;
	}


	
	/**
	 *Aceasta metoda creeaza o clona a obiectului 
	 */
	public Book clone() throws CloneNotSupportedException
    {
       Book copy=(Book)super.clone();
       copy.title=title;
       copy.author=author;
       copy.noBooks=noBooks;
       copy.price=price;
       copy.year=year;
       return copy;
    }
	
	/**
	 *Aceasta metoda afiseaza un obiect
	 */
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + ", price=" + price + ", noBooks="
				+ noBooks + "]";
	}
	
	
	
}
