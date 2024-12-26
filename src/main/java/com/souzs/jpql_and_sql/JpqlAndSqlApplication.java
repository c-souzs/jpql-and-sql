package com.souzs.jpql_and_sql;

import com.souzs.jpql_and_sql.dto.CustomerMinDTO;
import com.souzs.jpql_and_sql.dto.MovieMinDTO;
import com.souzs.jpql_and_sql.projections.CustomerMinProjection;
import com.souzs.jpql_and_sql.projections.MovieMinProjection;
import com.souzs.jpql_and_sql.repositories.CustomerRepository;
import com.souzs.jpql_and_sql.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpqlAndSqlApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpqlAndSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*List<CustomerMinProjection> customersProjection = customerRepository.searchByStateNative("MG");
		List<CustomerMinDTO> customersDTO = customersProjection.stream()
				.map(CustomerMinDTO::new).toList();

		System.out.println("Search state by native SQL");
		customersDTO.forEach(System.out::println);

		customersDTO = customerRepository.searchByStateJPQL("RS");
		System.out.println("Search state by JPQL");
		customersDTO.forEach(System.out::println);*/

		List<MovieMinProjection> moviesProjection = movieRepository.searchByGenreNameNative("Action");
		List<MovieMinDTO> moviesDTO = moviesProjection.stream().map(MovieMinDTO::new).toList();

		System.out.println("Search genre by native SQL");
		moviesDTO.forEach(System.out::println);

		moviesDTO = movieRepository.searchByGenreNameJPQL("Action");
		System.out.println("Search genre by native JPQL");
		moviesDTO.forEach(System.out::println);
	}
}
