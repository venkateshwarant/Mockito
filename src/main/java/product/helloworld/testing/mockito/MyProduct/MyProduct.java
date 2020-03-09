package product.helloworld.testing.mockito.MyProduct;
import java.util.HashMap;

public class MyProduct {
	APIDataManagementInterface service;
	
	public MyProduct(APIDataManagementInterface service) {
		this.service= service;
	}
	
	public int Db_TEST_Insert(String name, String value) {
		return service.Db_TEST_Insert(name, value);
	}
	
	public HashMap<Integer, String> Db_TEST_Select(){
		return service.Db_TEST_Select();
	}
	
	
}
