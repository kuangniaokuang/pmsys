package cn.labsys.pmsys;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/organization").setViewName("organization");
		registry.addViewController("/empmanager").setViewName("employee");
		registry.addViewController("/empedit").setViewName("employee-edt");
		registry.addViewController("/reqmanager").setViewName("requirement");
		registry.addViewController("/reqedit").setViewName("requirement-edt");
		registry.addViewController("/recmanager").setViewName("recruitment");
		registry.addViewController("/recedit").setViewName("recruitment-edt");
		registry.addViewController("/salary").setViewName("salary");
		registry.addViewController("/salarydepartment").setViewName("salarydepartment");
	}
}
