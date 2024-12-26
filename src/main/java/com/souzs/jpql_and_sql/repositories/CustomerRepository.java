package com.souzs.jpql_and_sql.repositories;

import com.souzs.jpql_and_sql.dto.CustomerMinDTO;
import com.souzs.jpql_and_sql.entities.Customer;
import com.souzs.jpql_and_sql.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true, value = " SELECT name FROM customers WHERE UPPER(state) = UPPER(:state)")
    List<CustomerMinProjection> searchByStateNative(String state);

    @Query(value = " SELECT new com.souzs.jpql_and_sql.dto.CustomerMinDTO(obj.name) " +
            "FROM Customer obj " +
            "WHERE UPPER(obj.state) = UPPER(:state)")
    List<CustomerMinDTO> searchByStateJPQL(String state);
}
