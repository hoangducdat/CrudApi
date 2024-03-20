package org.aibles.teamjava.Crud.Controller;

import org.aibles.teamjava.Crud.Entity.Category;
import org.aibles.teamjava.Crud.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category newCategory) {
        Category createCategory = categoryService.createCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategory);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Category updateCategory = categoryService.updateCategory(id,categoryDetails);
        return ResponseEntity.ok(updateCategory);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
