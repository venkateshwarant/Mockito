package product.helloworld.testing.mockito.MyProduct;
import java.util.HashMap;

public class MyProduct {
	APIDataManagementInterface service;
	
	public MyProduct(APIDataManagementInterface service) {
		this.service= service;
	}
	
	public int myCustomInsert(String name, String value) {
		return service.Db_TEST_Insert(name, value);
	}
	
	public HashMap<Integer, String> myCustomSelect(){
		return service.Db_TEST_Select();
	}
	
	
}
