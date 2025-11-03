
package com.ifes.configuracion;
import javax.jdo.PersistenceManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jdo.JDOHelper;

@Configuration
public class Configuracion {
    @Bean
    public PersistenceManagerFactory pmf() {
        return JDOHelper.getPersistenceManagerFactory("mysql");
    }
}
