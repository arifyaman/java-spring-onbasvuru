package com.yaman.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
 
@EnableWebMvc
@Configuration
@ComponentScan({ "com.yaman.web" })	//Web Config İşlemlerinin yapıldığı nesne. Controller ve diğer web componentleri için package belirlenir. 
public class SpringWebConfig extends WebMvcConfigurerAdapter {
 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//bootstrap validator gibi js ve css kaynaklarının bulunduğu kısım kaynak olarak gösterilir. Build edildiğinde projenin dosyalara assets dizininden ulaşabilmesi için.
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}
	
	@Bean		//Bean konfigürasyonu jsp dosyalarının dizini belirlenir.
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	//Bean konfigürasyonu valid annotation kullanıldığı için dizin konfigüre edilir.
	//form post edildiğinde alınan basvuruform nesnesinin geçerli olup olmadığının kontrolü için
	@Bean		
	public ResourceBundleMessageSource getResourceBundleMessageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource =new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("/WEB-INF/views/jsp/");
		return resourceBundleMessageSource;
	}
 
}