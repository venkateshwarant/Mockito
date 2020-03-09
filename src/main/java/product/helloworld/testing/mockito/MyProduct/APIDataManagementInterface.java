package product.helloworld.testing.mockito.MyProduct;

import java.util.HashMap;

public interface APIDataManagementInterface {

	
	/**
	 * @param name
	 * @param value
	 * @return 0 if its properly inserted in db
	 * 		   1 if any exception occurs
	 */
	public int Db_TEST_Insert(String name, String value);
	
	/**
	 * @return HashMap of contents from DB
	 */
	public HashMap<Integer, String> Db_TEST_Select();
	
	
}
