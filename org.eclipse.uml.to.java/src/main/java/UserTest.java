import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Core.User;
import Persist.UserJDBC;

public class UserTest {

	protected UserJDBC u;
	
	@Before
	public void setUp() throws Exception {
		u = new UserJDBC();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			setUp();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			setFirstName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			getFirstName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			setMobile();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			getMobile();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			setMailAddress();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			getMailAddress();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			setSurName();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			getSurName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setFirstName() throws Exception
	{
		u.setFirstName("JOELAMOUCHE");
		assertEquals("JOELAMOUCHE",u.getFirstName());
	}
	
	public void getFirstName() throws Exception
	{
		assertEquals("JOELAMOUCHE",u.getFirstName());
	}
	
	public void setMobile() throws Exception
	{
		u.setMobile("0781638080");
		assertEquals("0781638080",u.getMobile());
	}
	
	public void getMobile() throws Exception
	{
		assertEquals("0781638080",u.getMobile());
	}
	
	public void setMailAddress() throws Exception
	{
		u.setMailAddress("address@gmail.com");
		assertEquals("address@gmail.com",u.getMailAddress());
	}
	
	public void getMailAddress() throws Exception
	{
		assertEquals("address@gmail.com",u.getMailAddress());
	}
	
	public void setSurName() throws Exception
	{
		u.setSurName("Juanito");
		assertEquals("Juanito",u.getSurName());
	}
	
	public void getSurName() throws Exception
	{
		assertEquals("Juanito",u.getSurName());
	}
	
	

}
