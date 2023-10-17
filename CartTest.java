package bookstore;

import org.junit.Assert;
import org.junit.Test;

class CartTest {

	@Test
	void test() {
		Cart c= new Cart();
		Book a=new Book("x","y",2000,15.1,50,true);
		Book b=new Book("x","y",2000,20,50,true);
		c.addELement(a);
		c.addELement(b);
		System.out.println(c.sum());
		Assert.assertEquals(15.1*50+20*50, c.sum());
	}

}
