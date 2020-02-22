package com.p7.msl.repository;

import com.p7.msl.Entity.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends CrudRepository <Categories, Long> {

    List<Categories> findAllByOrderByIdAsc();
}
