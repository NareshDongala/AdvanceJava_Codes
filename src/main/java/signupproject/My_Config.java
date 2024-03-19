package signupproject;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "signupproject")
public class My_Config {
    @Bean(value="entityManager")
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("naresh").createEntityManager();
	}
}
