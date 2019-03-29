package sample.spring.chapter12;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "sample.spring.chapter12.domain",
        "sample.spring.chapter12.dao", "sample.spring.chapter12.service" })
public class RootContextConfig {

}
