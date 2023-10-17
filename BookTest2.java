package bookstore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BookTest2 {

	@Test
	public void test() {
		Book a=new Book("x","y",2000,15.1,50,true);
		a.setNoBooks(48);
		//Assertions.assertEquals(48,a.getNoBooks() ,"ok");
		
	}

}
