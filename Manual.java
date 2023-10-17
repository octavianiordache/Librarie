package bookstore;

public class Manual {
	/**
	 * Materia pentru care este manualul
	 */
	String subject;
	
	/**
	 * Editura de care este scris manualul
	 */
	String editure;
	
	/**
	 * Anul aparitiei
	 */
	int year;
	
	/**
	 * Pretul manualului
	 */
	double price;
	
	/**
	 * Numarul de manuale disponibile
	 */
	int noManuals;
	
	/**
	 * Constructor cu parametrii
	 * @param subject preia materia si o seteaza
	 * @param editure preia editura si o seteaza
	 * @param year preia anul si il seteaza
	 * @param price preia pretul si il seteaza
	 * @param noManuals preia numarul de manuale si il seteaza
	 */
	public Manual(String subject, String editure, int year, double price, int noManuals) {
		this.subject = subject;
		this.editure = editure;
		this.year = year;
		this.price = price;
		this.noManuals = noManuals;
	}
	
	/**
	 * @return returneaza materia
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * 
	 * @param subject preia materia si o seteaza
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * 
	 * @return returneaza editura
	 */
	public String getEditure() {
		return editure;
	}
	
	/**
	 * 
	 * @param editure preia editura si o seteaza
	 */
	public void setEditure(String editure) {
		this.editure = editure;
	}
	
	/**
	 * 
	 * @return returneaza anul aparitiei
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * 
	 * @param year preia anul si il seteaza
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * 
	 * @return returneaza pretul
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @param price preia pretul si il seteaza
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * 
	 * @return returneaza numarul de manuale
	 */
	public int getNoManuals() {
		return noManuals;
	}
	
	/**
	 * 
	 * @param noManuals preia numarul de manuale si il seteaza
	 */
	public void setNoManuals(int noManuals) {
		this.noManuals = noManuals;
	}
	
	/**
	 * Metoda pentru afisarea unui manual
	 */
	@Override
	public String toString() {
		return "Manual [subject=" + subject + ", editure=" + editure + ", year=" + year + ", price=" + price
				+ ", noManuals=" + noManuals + "]";
	}
}

