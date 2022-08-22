package Tuehv_jv6.service;

import java.util.List;

import Tuehv_jv6.entity.Category;
import Tuehv_jv6.entity.Product;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    Category create(Category category);

    Category update(Category category);

     void delete(Integer id);
}
