package bookstore;

public class WritingTool {
	/**
	 * Denumirea instrumentului de scris
	 */
	String name;
	
	/**
	 * Pretul produsului
	 */
	double price;
	
	/**
	 * Numarul de obiecte disponibile
	 */
	int noTools;
	
	/**
	 * Constructor cu parametrii
	 * @param name preia numele si il seteaza
	 * @param price preia pretul si il seteaza
	 * @param noTools preia numarul si il seteaza
	 */
	public WritingTool(String name, double price, int noTools) {
		this.name = name;
		this.price = price;
		this.noTools = noTools;
	}

	/**
	 * 
	 * @return returneaza numele
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name preia numele si il seteaza
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return returneaza numarul de obiecte
	 */
	public int getNoTools() {
		return noTools;
	}

	/**
	 * 
	 * @param noTools preia numarul de obiecte si il seteaza
	 */
	public void setNoTools(int noTools) {
		this.noTools = noTools;
	}

	/**
	 * Metoda pentru afisarea unui obiect de tip instrument de scris
	 */
	@Override
	public String toString() {
		return "WritingTool [name=" + name + ", price=" + price + ", noTools=" + noTools + "]";
	}
	
	
}
