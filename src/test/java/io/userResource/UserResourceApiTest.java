package io.userResource;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
public class UserResourceApiTest extends UserResourceApiSrpingbootApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void verifyGetAllUsers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/Allusers")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
			.andExpect(jsonPath("$", hasSize(4))).andDo(print());
	}
	
	@Test
	public void testGetById()  throws Exception {
		mockMvc.perform(get("/users/1")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.id").value("1")).andExpect(jsonPath("$.fName").value("Prashant"))
		.andExpect(jsonPath("$.lName").value("Singh")).andExpect(jsonPath("$.email").value("singh.prashant1603@gmail.com"))
		.andExpect(jsonPath("$.pinCode").value("411007")).andExpect(jsonPath("$.birthDate").value("16-03-991"))
		.andExpect(jsonPath("$.active").value("true"));

	}
	
	@Test
	public void verifyDeleteById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/users/1")).andExpect(status().isOk())
		.andExpect(content().string("Successfully deleted user :1"))
		.andDo(print());
}
	/*TODO correct this*/
	/*@Test
	public void testUpdateUser()  throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/users/1")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.id").value("1")).andExpect(jsonPath("$.fName").value("Prashant"))
		.andExpect(jsonPath("$.lName").value("Singh")).andExpect(jsonPath("$.email").value("singh.prashant1603@gmail.com"))
		.andExpect(jsonPath("$.pinCode").value("411007")).andExpect(jsonPath("$.birthDate").value("16-03-991"))
		.andExpect(jsonPath("$.active").value("true"));

	}
*/

}
