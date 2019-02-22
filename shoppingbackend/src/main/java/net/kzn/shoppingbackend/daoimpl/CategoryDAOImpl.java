package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
    
	private static List<Category> categories = new ArrayList<Category>();
	
	static {
		
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is Static data for Television");
		category.setImageURL("tl.jpg");
		
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is Static data for Mobile");
		category.setImageURL("ml.jpg");
		
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is Static data for Laptop");
		category.setImageURL("ll.jpg");
		
		categories.add(category);
		
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
