package com.example.backendrestaurante.repository;

import com.example.backendrestaurante.models.entity.Producto;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

public class ProductoSpecification {

    public static Specification<Producto> withFilters(List<String> categorias, String search){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(categorias !=null && !categorias.isEmpty()){
                predicates.add(root.get("categoria").get("nombre").in(categorias));
            }

            if(search !=null && !search.isEmpty()){
                predicates.add(criteriaBuilder.like(root.get("nombre"),"%"+search+"%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
