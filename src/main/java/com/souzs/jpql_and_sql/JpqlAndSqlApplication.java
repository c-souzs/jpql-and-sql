package com.souzs.jpql_and_sql;

import com.souzs.jpql_and_sql.dto.CustomerMinDTO;
import com.souzs.jpql_and_sql.projections.CustomerMinProjection;
import com.souzs.jpql_and_sql.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpqlAndSqlApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpqlAndSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CustomerMinProjection> customersProjection = customerRepository.searchByStateNative("MG");
		List<CustomerMinDTO> customersDTO = customersProjection.stream()
				.map(CustomerMinDTO::new).toList();

		System.out.println("Search state by native SQL");
		customersDTO.forEach(System.out::println);

		customersDTO = customerRepository.searchByStateJPQL("RS");
		System.out.println("Search state by JPQL");
		customersDTO.forEach(System.out::println);
	}
}
