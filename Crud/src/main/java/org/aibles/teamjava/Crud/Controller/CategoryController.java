package org.aibles.teamjava.Crud.Controller;

import org.aibles.teamjava.Crud.Entity.Category;
import org.aibles.teamjava.Crud.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/crud/category")
public class CategoryController {
    private static final Logger LOGGER = Logger.getLogger(CategoryController.class.getName());
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public List<Category> getAllCategory() {
        LOGGER.info("GET ALL CATEGORY");
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        LOGGER.info("GET CATEGORY BY ID");
        return categoryService.getCategoryById(id);
    }
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category newCategory) {
        LOGGER.info("CREATE CATEGORY");
        Category createCategory = categoryService.createCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategory);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        LOGGER.info("UPDATE CATEGORY");
        Category updateCategory = categoryService.updateCategory(id,categoryDetails);
        return ResponseEntity.ok(updateCategory);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        LOGGER.info("DELETE CATEGORY");
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
