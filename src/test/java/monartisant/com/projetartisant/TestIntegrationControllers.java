package monartisant.com.projetartisant;

import monartisant.com.projetartisant.model.Category;
import monartisant.com.projetartisant.ws.CategoryController;
import monartisant.com.projetartisant.ws.CategoryService;
import org.glassfish.jersey.servlet.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.ws.rs.core.MediaType;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
@WebMvcTest(controllers = CategoryController.class)
public class TestIntegrationControllers {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    CategoryService categoryService;
    @Autowired
    WebApplicationContext context;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();

    }

    @Test
    public void getCategoryById() throws Exception {
        Mockito.when(categoryService.getCategory()).thenReturn(new Category(1L, "IMMOBILIER", "this is description", "batima", null));

        MvcResult result = mockMvc
                .perform(get("/categorybyid")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect()
                //  .andExpect(content().string(containsString("this is description")))
                .andDo(print())
                .andReturn();
        System.out.println(result.getResponse().getStatus());
    }

//    @Test
//    public void postUserbyId() throws Exception{
//        Mockito.when(categoryRepository.getOne(1L)).thenReturn(new User(1L,"first test",null,10,false,1234,null,null,null,null,null,null));
//        MvcResult result =  mockMvc.perform(post("userbyid/1")).andExpect(status().isOk()).andReturn();
//        System.out.println(result.getResponse().getContentAsString());
//    }
}
