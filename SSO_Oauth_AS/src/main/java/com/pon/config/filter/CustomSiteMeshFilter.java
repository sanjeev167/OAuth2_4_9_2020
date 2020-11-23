/**
 * 
 */
package com.pon.config.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.stereotype.Component;

/**
 * @author Sanjeev
 *
 */
@Component
public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder
				// Exclude path from decoration.
				.addExcludedPath("/resources/*")
				//.setIncludeErrorPages(true)
				// Assigning default decorator if no path specific decorator found
				// .addDecoratorPath("/*.jsp", "/WEB-INF/decorator/no_decorator.jsp")
					
				.addDecoratorPath("/", "/WEB-INF/decorator/home_decorator.jsp")				
				.addDecoratorPath("/home", "/WEB-INF/decorator/home_decorator.jsp")
				.addDecoratorPath("/login", "/WEB-INF/decorator/home_decorator.jsp").create();			
				
		
	}// End of applyCustomConfiguration
	
	

}// End of CustomSiteMeshFilter