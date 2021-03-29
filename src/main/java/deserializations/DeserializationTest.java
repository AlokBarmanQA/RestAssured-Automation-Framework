package deserializations;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeserializationTest {
	
	@Test
	public void deserialization_test() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		
		DeserializationPojo pojoObject = RestAssured.given().when().get().as(DeserializationPojo.class);
		
//		System.out.println(pojoObject.toString());
		
		System.out.println("Data List: " + pojoObject.getData());
		
		List<DataPojo> list = pojoObject.getData();
		for(int i=0; i<list.size(); i++) {
			System.out.println("Index "+i+" elements:: "+list.get(i));
		}
	}
}
