package com.pluralsight.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

//@Configuration
public class PersistanceConfiguration {

//	@Autowired
//    private Environment env;
//	@Bean
//	public DataSource datasource() {
//		DataSourceBuilder builder = DataSourceBuilder.create();
//		String url=env.getProperty("DB_URL");
//		builder.url(url);
//		return builder.build();
//
//	}
}
