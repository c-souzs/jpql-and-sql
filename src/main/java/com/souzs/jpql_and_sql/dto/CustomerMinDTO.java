package com.souzs.jpql_and_sql.dto;

import com.souzs.jpql_and_sql.projections.CustomerMinProjection;

public class CustomerMinDTO {
    private String name;

    public CustomerMinDTO() {
    }

    public CustomerMinDTO(String name) {
        this.name = name;
    }

    public CustomerMinDTO(CustomerMinProjection projection) {
        name = projection.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CustomerMinDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
