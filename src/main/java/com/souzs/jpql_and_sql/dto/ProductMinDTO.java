package com.souzs.jpql_and_sql.dto;

import com.souzs.jpql_and_sql.projections.ProductMinProjection;

public class ProductMinDTO {
    private String name;

    public ProductMinDTO() {
    }

    public ProductMinDTO(String name) {
        this.name = name;
    }

    public ProductMinDTO(ProductMinProjection projection) {
        name = projection.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductMinDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
