package com.souzs.jpql_and_sql.repositories;

import com.souzs.jpql_and_sql.dto.ProductMinDTO;
import com.souzs.jpql_and_sql.entities.Product;
import com.souzs.jpql_and_sql.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(nativeQuery = true, value = "SELECT pd.name " +
            "FROM products pd JOIN providers pv ON pd.id_providers = pv.id " +
            "WHERE pv.name LIKE CONCAT(:beginName, '%') AND pd.amount BETWEEN :min AND :max")
    List<ProductMinProjection> searchProductNative(Integer min, Integer max, String beginName);

    @Query("SELECT new com.souzs.jpql_and_sql.dto.ProductMinDTO(obj.name) " +
            "FROM Product obj " +
            "WHERE obj.provider.name LIKE CONCAT(:beginName, '%') " +
            "AND obj.amount BETWEEN :min AND :max")
    List<ProductMinDTO> searchProductJPQL(Integer min, Integer max, String beginName);
}