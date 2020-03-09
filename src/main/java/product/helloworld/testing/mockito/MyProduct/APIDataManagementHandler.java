package product.helloworld.testing.mockito.MyProduct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


public class APIDataManagementHandler implements APIDataManagementInterface{




	private static final String USER_AGENT = "Mozilla/5.0";
		private static final String BASE_URL = "http://localhost:8080/product.helloworld";
		public int Db_TEST_Insert(String name, String value) {
			try {
				URL obj = new URL(BASE_URL+"/insert");
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("User-Agent", USER_AGENT);
				con.setDoOutput(true);
				OutputStream os = con.getOutputStream();
				String POST_PARAMS = "name="+name+"&value="+value;
				os.write(POST_PARAMS.getBytes());
				os.flush();
				os.close();
				int responseCode = con.getResponseCode();
				StringBuffer response = new StringBuffer();
				System.out.println("POST Response Code :: " + responseCode);
				if (responseCode == HttpURLConnection.HTTP_OK) { //success
					BufferedReader in = new BufferedReader(new InputStreamReader(
							con.getInputStream()));
					String inputLine;
	
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					System.out.println(response.toString());
				} else {
					System.out.println("POST request not worked");
				}
				if(response.toString().contentEquals("<html><body><b>Successfully Inserted</b></body></html>")){
					return 0;
				}else {
					return 1;
				}
			} catch (Exception e) {
				System.out.print(e);
				return 1;
			}
		}


		public HashMap<Integer, String> Db_TEST_Select() {
			try {
				URL obj = new URL(BASE_URL+"/select");
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", USER_AGENT);
				con.setDoOutput(true);

				int responseCode = con.getResponseCode();
				StringBuffer response = new StringBuffer();
				System.out.println("POST Response Code :: " + responseCode);
				if (responseCode == HttpURLConnection.HTTP_OK) { //success
					BufferedReader in = new BufferedReader(new InputStreamReader(
							con.getInputStream()));
					String inputLine;
	
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					System.out.println(response.toString());
				} else {
					System.out.println("POST request not worked");
				}
				if(response.toString().contains("Data in table TEST collected at")){
					HashMap<Integer, String> values = new HashMap<Integer, String>();
					String[] arr= response.toString().split(" the values are ");
					String interm[]= arr[1].split("</h3><br/>");
					values.put(1, interm[0]);
					values.put(2, "helloworld");

					return values;
				}else {
					return new HashMap<Integer, String>();
				}
			} catch (Exception e) {
				System.out.print(e);
				return new HashMap<Integer, String>();
			}
		}

	
	
}
