package com.example.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SiteMeshConfig {
	
	@Bean
	FilterRegistrationBean siteMeshFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new ConfigurableSiteMeshFilter() {
			@Override
			protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				builder.addDecoratorPath("/country/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/city/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/dept/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/emp/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/Admin*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/User*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/Auth*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/sal*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/dnltime/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/manchester/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/players/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/molecule/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/Sign_in/*", "/WEB-INF/decorators/default.jsp");
				builder.addDecoratorPath("/memo/*", "/WEB-INF/decorators/default.jsp");

				builder.addDecoratorPath("/*", "/WEB-INF/decorators/default.jsp");

				builder.addExcludedPath("/sal/GetMemberLists");
			}
		});
//		filter.addUrlPatterns("/*");
		return filter;
	}

}
