package ar.edu.uca;

import java.util.Arrays;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
//import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@SpringBootApplication
@EnableJpaRepositories("ar.edu.uca.repositories")
@EnableTransactionManagement
@EntityScan("ar.edu.uca.entities")
@ComponentScan
@EnableCaching
@EnableAutoConfiguration
@Configuration
@ConfigurationProperties()
public class Application  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("basicCache")));
        return cacheManager;

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

//	   @Value("${spring.datasource.dataSourceClassName}")
//	   private String dataSourceClassName;

    @Value("${spring.datasource.poolName}")
    private String poolName;

    @Value("${spring.datasource.connectionTimeout}")
    private int connectionTimeout;

    @Value("${spring.datasource.maxLifetime}")
    private int maxLifetime;

    @Value("${spring.datasource.maximumPoolSize}")
    private int maximumPoolSize;

    @Value("${spring.datasource.minimumIdle}")
    private int minimumIdle;

    @Value("${spring.datasource.idleTimeout}")
    private int idleTimeout;

    @Value("${spring.jpa.hibernate.ddl-generate}")
    private Boolean ddlGenerate;

    @Value("${spring.jpa.show-sql}")
    private Boolean showSql;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Bean
    public DataSource dataSource() {
        Properties dsProps = new Properties();
        dsProps.put("jdbcUrl", dataSourceUrl);
        dsProps.put("url", dataSourceUrl);
        dsProps.put("user", user);
        dsProps.put("password", password);

        Properties configProps = new Properties();
//        configProps.put("dataSourceClassName", dataSourceClassName);
        configProps.put("jdbcUrl", dataSourceUrl);
        configProps.put("poolName", poolName);
        configProps.put("maximumPoolSize", maximumPoolSize);
        configProps.put("minimumIdle", minimumIdle);
        configProps.put("connectionTimeout", connectionTimeout);
        configProps.put("idleTimeout", idleTimeout);
        configProps.put("dataSourceProperties", dsProps);


        HikariConfig hc = new HikariConfig(configProps);
        HikariDataSource ds = new HikariDataSource(hc);
        return ds;
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Jackson2ObjectMapperBuilder configureObjectMapper() {
        return new Jackson2ObjectMapperBuilder()
                .modulesToInstall(Hibernate5Module.class);
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(showSql);
        adapter.setGenerateDdl(ddlGenerate);
        adapter.setDatabasePlatform(dialect);
        if (dialect.toLowerCase().contains("h2"))
            adapter.setDatabase(Database.H2);
        else if (dialect.toLowerCase().contains("oracle"))
            adapter.setDatabase(Database.ORACLE);
        else
            adapter.setDatabase(Database.MYSQL);
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendeorAdapter) {
        try {
            LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactory.setDataSource(dataSource);
            entityManagerFactory.setJpaVendorAdapter(jpaVendeorAdapter);
            entityManagerFactory.setPackagesToScan("ar.edu.uca.entities");
            return entityManagerFactory;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
