package sample.spring.chapter12;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import sample.spring.chapter12.web.FixedDepositController;


@Configuration
@ComponentScan(basePackages="sample.spring.chapter12",
        excludeFilters = @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,
                value= FixedDepositController.class))
public class AppConfig {
}
