package net.kzn.shoppingbackend.Test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Laptop");
	 * category.setDescription("This is some description for laptop!");
	 * category.setImageURL("CAT_105.png");
	 * 
	 * assertEquals("Successfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void getCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * assertEquals("Successfully get a single category","Laptop",
	 * category.getName()); }
	 */
	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(2);
	 * 
	 * category.setName("Television");
	 * category.setDescription("This is some description for Television!");
	 * category.setImageURL("CAT_106.png");
	 * 
	 * assertEquals("Successfully Updated!", true, categoryDAO.update(category));
	 * 
	 * }
	 */

	/*@Test
	public void testDeleteCategory() {

		category = categoryDAO.get(2);
		assertEquals("Successfully deleted!",true, categoryDAO.delete(category));

	}*/
	
	@Test
	public void testListCategory() {
					
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());
		
		
	}

}
