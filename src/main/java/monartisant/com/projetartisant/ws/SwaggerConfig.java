package monartisant.com.projetartisant.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Plat Forme Service")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("monartisant.com.projetartisant.ws"))
                .paths(regex(".*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Plat Forme Service - Diaguily Sylla")
                .description("Sample Documentation Generateed Using SWAGGER2 for our Plat form service user Rest API")
                .termsOfServiceUrl("https://myUrl")
                .license("Java_Diaguily-Sylla License")
                .licenseUrl("https://myURL").version("1.0").build();
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}