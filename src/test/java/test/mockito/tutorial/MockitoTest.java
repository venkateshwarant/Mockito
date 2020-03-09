package test.mockito.tutorial;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import product.helloworld.testing.mockito.MyProduct.APIDataManagementHandler;
import product.helloworld.testing.mockito.MyProduct.APIDataManagementInterface;
import product.helloworld.testing.mockito.MyProduct.MyProduct;





public class MockitoTest {

	APIDataManagementInterface mockService1= Mockito.mock(APIDataManagementInterface.class);
	APIDataManagementInterface mockService2= new APIDataManagementHandler();

	
	MyProduct myProduct1;
	MyProduct myProduct2;



	@Before
	public void setup() {
	    myProduct1= new MyProduct(mockService1);
		myProduct2= new MyProduct(mockService2);
		
		
		when(myProduct1.Db_TEST_Insert("key", "value")).thenReturn(0);
		when(myProduct1.Db_TEST_Insert("", "value")).thenReturn(1);
		when(myProduct1.Db_TEST_Insert("key1", "value1")).thenReturn(0);
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(1, "key");
		when(myProduct1.Db_TEST_Select()).thenReturn(hashmap);
		
	}
	

	@Test
	public void testDb_TEST_Insert() throws IOException {
		assertEquals(0, myProduct1.Db_TEST_Insert("key", "value"));
		verify(mockService1).Db_TEST_Insert("key", "value");
	}
	 
	
	/**
	 * Fails because the API returns 1 for empty key because of exception
	 * @throws IOException
	 */
	@Test
	public void testDb_TEST_Insert_Empty_key() throws IOException {
		assertEquals(0, myProduct1.Db_TEST_Insert("key", "value"));
		verify(mockService1).Db_TEST_Insert("key", "value");
	}
	
	@Test
	public void testDb_TEST_Select() throws IOException {
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(1, "key");
		assertEquals(hashmap, myProduct1.Db_TEST_Select());
		verify(mockService1).Db_TEST_Select();
	}
	
	@Test
	public void testDb_TEST_Insert_From_Service() throws IOException {
		
		assertEquals(0, myProduct2.Db_TEST_Insert("key", "value"));
//		verify(mockService2).Db_TEST_Select();
	}
	
	@Test
	public void testDb_TEST_Select_From_Service() throws IOException {
		
		assertEquals("helloworld", myProduct2.Db_TEST_Select().get(2));
//		verify(mockService2).Db_TEST_Select();
	}
}
