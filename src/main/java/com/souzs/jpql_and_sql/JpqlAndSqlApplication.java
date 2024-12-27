package com.souzs.jpql_and_sql;

import com.souzs.jpql_and_sql.dto.*;
import com.souzs.jpql_and_sql.projections.*;
import com.souzs.jpql_and_sql.repositories.CustomerRepository;
import com.souzs.jpql_and_sql.repositories.LawyerRepository;
import com.souzs.jpql_and_sql.repositories.MovieRepository;
import com.souzs.jpql_and_sql.repositories.ProductRepository;
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

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private LawyerRepository lawyerRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpqlAndSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// URI 2602
		/*List<CustomerMinProjection> customersProjection = customerRepository.searchByStateNative("MG");
		List<CustomerMinDTO> customersDTO = customersProjection.stream()
				.map(CustomerMinDTO::new).toList();

		System.out.println("Search state by native SQL");
		customersDTO.forEach(System.out::println);

		customersDTO = customerRepository.searchByStateJPQL("RS");
		System.out.println("Search state by JPQL");
		customersDTO.forEach(System.out::println);*/

		// URI 2611
		/*List<MovieMinProjection> moviesProjection = movieRepository.searchByGenreNameNative("Action");
		List<MovieMinDTO> moviesDTO = moviesProjection.stream().map(MovieMinDTO::new).toList();

		System.out.println("Search genre by native SQL");
		moviesDTO.forEach(System.out::println);

		moviesDTO = movieRepository.searchByGenreNameJPQL("Action");
		System.out.println("Search genre by JPQL");
		moviesDTO.forEach(System.out::println);*/

		// URI 2611
		/*List<ProductMinProjection> productsProjection = productRepository.searchProductNative(10, 20, "P");
		List<ProductMinDTO> productsDTO = productsProjection.stream().map(ProductMinDTO::new).toList();

		System.out.println("Search name and amount by native SQL");
		productsDTO.forEach(System.out::println);

		productsDTO = productRepository.searchProductJPQL(10, 20, "P");
		System.out.println("Search name and amount by JPQL");
		productsDTO.forEach(System.out::println);*/

		// URI 2609
		/*List<CategorySumProjection> categoriesProjection = productRepository.searchProductGroupByNative();
		List<CategorySumDTO> categoriesDTO = categoriesProjection.stream().map(CategorySumDTO::new).toList();

		System.out.println("Search group by with native SQL");
		categoriesDTO.forEach(System.out::println);

		categoriesDTO = productRepository.searchProductGroupByJPQL();
		System.out.println("Search name and amount by JPQL");
		categoriesDTO.forEach(System.out::println);*/

		// URI 2737
		List<LawyerMinProjection> lawyersProjection = lawyerRepository.searchUnionByNative();
		List<LawyerMinDTO> lawyersDTO = lawyersProjection.stream().map(LawyerMinDTO::new).toList();

		System.out.println("Search union with native SQL");
		lawyersDTO.forEach(System.out::println);
	}
}
