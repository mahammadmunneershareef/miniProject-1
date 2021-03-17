package com.Price.quotation.Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.Price.quotation.Service.RequestServiceImpl;
import com.Price.quotation.Service.UserServiceImpl;
import com.Price.quotation.Service.VendorServiceImpl;
@Configuration
public class DBConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// MySQL database we are using
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/priceQuotation?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("shareef");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public UserServiceImpl UserServiceMethod() {
		UserServiceImpl user = new UserServiceImpl();
		user.setJdbcTemplate(jdbcTemplate());
		return user;
	}
	@Bean
	public VendorServiceImpl VendorServiceMethod() {
		VendorServiceImpl vendor = new VendorServiceImpl();
		vendor.setJdbcTemplate(jdbcTemplate());
		return vendor;
	}
	@Bean
	public RequestServiceImpl RequestServiceMethod() {
		RequestServiceImpl request = new RequestServiceImpl();
		request.setJdbcTemplate(jdbcTemplate());
		return request;
	}
	@Bean
	public InternalResourceViewResolver resolver() {
	    InternalResourceViewResolver vr = new InternalResourceViewResolver();
	    vr.setPrefix("/WEB-INF/views/");
	    vr.setSuffix(".jsp");
	    return vr;
	}
}
