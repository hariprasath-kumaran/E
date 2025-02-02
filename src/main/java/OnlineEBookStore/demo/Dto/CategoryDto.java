package OnlineEBookStore.demo.Dto;

import OnlineEBookStore.demo.Model.Category;
import OnlineEBookStore.demo.Request.CategoryRequest;
import OnlineEBookStore.demo.Response.CategoryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDto {
    public CategoryResponse mapToCategoryResponse(List<Category> categories) {
        CategoryResponse categoryResponse = new CategoryResponse();

        ArrayList<CategoryRequest> categoryrequest = new ArrayList<>();
        for (Category category : categories) {
            categoryrequest.add(new CategoryRequest(category.getId(), category.getTitle()));
        }

        categoryResponse.setCategories(categoryrequest);
        return categoryResponse;
    }

    public Category mapToCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        if (categoryRequest.getId() != null) {
            category.setId(categoryRequest.getId());
        }
        category.setTitle(categoryRequest.getTitle());
        return category;
    }
}
