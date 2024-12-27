package com.souzs.jpql_and_sql.repositories;

import com.souzs.jpql_and_sql.dto.EmpregadoDeptDTO;
import com.souzs.jpql_and_sql.entities.Empregado;
import com.souzs.jpql_and_sql.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
    @Query(nativeQuery = true, value = "SELECT emp.cpf, emp.enome, dpt.dnome FROM empregados emp " +
            "INNER JOIN departamentos dpt ON emp.dnumero = dpt.dnumero " +
            "LEFT JOIN trabalha trb ON emp.cpf = trb.cpf_emp " +
            "WHERE trb.cpf_emp IS NULL " +
            "ORDER BY emp.cpf")
    List<EmpregadoDeptProjection> searchEmpregadoByNative();

    @Query("SELECT new com.souzs.jpql_and_sql.dto.EmpregadoDeptDTO(obj.cpf, obj.enome, obj.departamento.dnome) " +
            "FROM Empregado obj " +
            "WHERE obj.projetosOndeTrabalha IS EMPTY " +
            "ORDER BY obj.cpf")
    List<EmpregadoDeptDTO> searchEmpregadoByJPQL();
}
