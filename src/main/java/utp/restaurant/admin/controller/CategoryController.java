
package utp.restaurant.admin.controller;

import utp.restaurant.admin.view.CategoryView;
import utp.restaurant.dao.CategoryDAO;

public class CategoryController {
    
   private CategoryView categoryView;
   private CategoryDAO categoryDAO;
   
   public CategoryController( CategoryView categoryView ){
     this.categoryView= categoryView;
     categoryDAO= new CategoryDAO();
   }
}
