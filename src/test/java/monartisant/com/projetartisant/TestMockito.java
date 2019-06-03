package monartisant.com.projetartisant;

import monartisant.com.projetartisant.model.Category;
import monartisant.com.projetartisant.repository.CategoryRepository;
import monartisant.com.projetartisant.ws.CategoryController;
import monartisant.com.projetartisant.ws.CategoryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestMockito {
    @Mock
    private CategoryService categoryService;
    @InjectMocks
    private CategoryController categoryController = new CategoryController(categoryService) ;

    @Before
    public void setUpMockito() throws Exception {

    }

    @Test
    public void getSuccessResultTest() {
        // Given
        Category category=	new  Category(1L, "IMMOBILIER", "this is description", "batima", null);
        // When
        Mockito.when(categoryService.getCategory()).thenReturn(category);
        categoryController.setCategoryRepository(categoryService);
      //  Mockito.verify(categoryService).getCategory();
        Assert.assertTrue(categoryController.getCategoryById().getName().contains("IMMOBILIER"));
    }
}
