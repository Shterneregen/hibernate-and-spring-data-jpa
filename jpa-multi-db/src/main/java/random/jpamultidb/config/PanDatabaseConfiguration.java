package random.jpamultidb.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import random.jpamultidb.domain.pan.CreditCardPAN;

import javax.sql.DataSource;

@EnableJpaRepositories(
        basePackages = "random.jpamultidb.repositories.pan",
        entityManagerFactoryRef = "panEntityManagerFactory",
        transactionManagerRef = "panTransactionManager"
)
@Configuration
public class PanDatabaseConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("spring.pan.datasource")
    public DataSourceProperties panDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    @ConfigurationProperties("spring.pan.datasource.hikari")
    public DataSource panDataSource(
            @Qualifier("panDataSourceProperties") DataSourceProperties panDataSourceProperties) {
        return panDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean panEntityManagerFactory(
            @Qualifier("panDataSource") DataSource panDataSource,
            EntityManagerFactoryBuilder builder) {
        return builder.dataSource(panDataSource)
                .packages(CreditCardPAN.class)
                .persistenceUnit("pan")
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager panTransactionManager(
            @Qualifier("panEntityManagerFactory") LocalContainerEntityManagerFactoryBean panEntityManagerFactory) {
        return new JpaTransactionManager(panEntityManagerFactory.getObject());
    }
}