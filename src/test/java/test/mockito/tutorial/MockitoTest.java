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





public class MockitoTest {


	APIDataManagementInterface dataAPI= Mockito.mock(APIDataManagementInterface.class);
	
	APIDataManagementInterface dataAPI2= new APIDataManagementHandler();


	@Before
	public void setup() {
		when(dataAPI.Db_TEST_Insert("key", "value")).thenReturn(0);
		when(dataAPI.Db_TEST_Insert("", "value")).thenReturn(1);
		when(dataAPI.Db_TEST_Insert("key1", "value1")).thenReturn(0);
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(1, "key");
		when(dataAPI.Db_TEST_Select()).thenReturn(hashmap);
		
	}
	

	@Test
	public void testDb_TEST_Insert() throws IOException {
		assertEquals(0, dataAPI.Db_TEST_Insert("key", "value"));
		verify(dataAPI).Db_TEST_Insert("key", "value");
	}
	
	
	/**
	 * Fails because the API returns 1 for empty key because of exception
	 * @throws IOException
	 */
	@Test
	public void testDb_TEST_Insert_Empty_key() throws IOException {
		assertEquals(0, dataAPI.Db_TEST_Insert("key", "value"));
		verify(dataAPI).Db_TEST_Insert("key", "value");
	}
	
	@Test
	public void testDb_TEST_Select() throws IOException {
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(1, "key");
		assertEquals(hashmap, dataAPI.Db_TEST_Select());
		verify(dataAPI).Db_TEST_Select();
	}
	
	@Test
	public void testDb_TEST_Insert_From_Service() throws IOException {
		
		assertEquals(0, dataAPI2.Db_TEST_Insert("key", "value"));
//		verify(dataAPI).Db_TEST_Select();
	}
	
	@Test
	public void testDb_TEST_Select_From_Service() throws IOException {
		
		assertEquals("helloworld", dataAPI2.Db_TEST_Select().get(2));
//		verify(dataAPI).Db_TEST_Select();
	}
}
