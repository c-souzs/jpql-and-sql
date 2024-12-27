package com.souzs.jpql_and_sql.repositories;

import com.souzs.jpql_and_sql.entities.Lawyer;
import com.souzs.jpql_and_sql.projections.LawyerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
    @Query(nativeQuery = true, value = "(SELECT name, customers_number AS customersNumber from lawyers " +
            "WHERE customers_number = ( " +
            "SELECT MAX(customers_number) FROM lawyers " +
            ")) " +
            "UNION ALL " +
            "(SELECT name, customers_number AS customersNumber FROM lawyers " +
            "ORDER BY customers_number ASC " +
            "LIMIT 1) " +
            "UNION ALL " +
            "SELECT 'Average', ROUND(AVG(customers_number), 0) AS customersNumber " +
            "FROM lawyers")
    List<LawyerMinProjection> searchUnionByNative();
}
