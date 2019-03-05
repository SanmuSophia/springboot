package gcyl.entity.config.web;

import gcyl.entity.filter.DealStreamFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author lican
 * @date 2019/2/19
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean register() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new DealStreamFilter());
        registration.addUrlPatterns("/*");
        registration.setName("DealStreamFilter");
        registration.setOrder(1);
        return registration;
    }
}
