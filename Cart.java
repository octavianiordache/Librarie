package bookstore;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	/**
	 * o lista de carti
	 */
	List<Book> books;
	
	/**
	 * o lista de unelte de scris
	 */
	List <WritingTool> writingTools;
	
	/**
	 * o lista de manuale
	 */
	List <Manual> manuals;
	
	/**
	 * constructor fara parametrii
	 */
	public Cart()
	{
		this.books=new ArrayList<Book>();
		this.writingTools= new ArrayList<WritingTool>();
		this.manuals= new ArrayList<Manual>();
	}

	/**
	 * constructor cu parametrii
	 * @param books o lista de carti
	 * @param writingTools o lista de unelte de scris
	 * @param manuals o lista de manuale
	 */
	public Cart(List<Book> books, List<WritingTool> writingTools, List<Manual> manuals) {
		this.books = books;
		this.writingTools = writingTools;
		this.manuals=manuals;
	}
	/**
	 * o metoda care face posibila adaugarea produselor in cosul de produse
	 * @param <Type> parametru ce face metoda generica
	 * @param element un produs care se adauga in cos
	 */
	public <Type> void addELement(Type element)
	{
		if(element instanceof Book)
			books.add((Book) element);
		else
			if(element instanceof Manual)
				manuals.add((Manual) element);
			else
				writingTools.add((WritingTool) element);
	}
	
	/**
	 * Metoda ce produce eliminarea unui produs din cos
	 * @param <Type> parametru ce face metoda generica
	 * @param type	un obiect generic
	 * @param index index care ajuta la identificarea obiectului
	 */
	public <Type> void removeElement(Class <Type> type, int index)
	{
		if(type==Book.class)
		{
			if(index >= 0 && index < books.size())
			{
				books.remove(index);
			}
		}else if(type == Manual.class)
		{
			if(index >= 0 && index < manuals.size())
			{
				manuals.remove(index);
			}
		}else
		{
			if(index >= 0 && index < writingTools.size())
			{
				writingTools.remove(index);
			}
		}
	}
	
	/**
	 * Metoda care calculeaza suma totala a produselor din cos
	 * @return returneaza pretul total
	 */
	public double sum()
	{
		double totalPrice=0.0;
		for(Book book: books)
		{
			totalPrice=totalPrice+ book.getNoBooks()*book.getPrice();
		}
		for(Manual manual: manuals)
		{
			totalPrice=totalPrice+ manual.getNoManuals()*manual.getPrice();
		}
		for(WritingTool tool: writingTools)
		{
			totalPrice=totalPrice+ tool.getNoTools()*tool.getPrice();
		}
		return totalPrice;
	}
	
	/**
	 * Metoda care afiseaza produsele din cos
	 */
	@Override
	public String toString() {
		return "Carti=" + books+ "\n" + "Instrumente=" + writingTools+ "\n" + "Manuale=" + manuals;
	}
	
	
}
