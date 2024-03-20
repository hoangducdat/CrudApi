package org.aibles.teamjava.Crud.ServiceImpl;

import org.aibles.teamjava.Crud.Entity.Category;
import org.aibles.teamjava.Crud.Repository.CatetogyRepository;
import org.aibles.teamjava.Crud.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CatetogyRepository catetogyRepository;
    @Override
    public List<Category> getAllCategories() {
        return catetogyRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return catetogyRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        return catetogyRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category categoryDetails) {
        return catetogyRepository.save(categoryDetails);
    }

    @Override
    public void deleteCategory(Long id) {
        catetogyRepository.deleteById(id);

    }
}
