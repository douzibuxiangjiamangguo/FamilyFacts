package uk.ac.chen.middleware.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import uk.ac.chen.middleware.util.SqliteBuilder;
import uk.ac.chen.middleware.util.SqliteUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: Qiuyu
 */
@MapperScan(basePackages = {"uk.ac.chen.middleware.mapper"},
        sqlSessionFactoryRef = "sqlSessionFactory")
@Configuration
public class SqliteConfig {

    @Value("${middleware.sqlite.url}")
    private String dataSourceUrl;

    /**
     * Configuring sqlite data sources
     * @return
     */
    @Bean(name = "sqliteDataSource")
    public DataSource sqliteDataSource(){
        //Try to create sqlite file - if it does not exist
        SqliteUtils.initSqliteFile(SqliteUtils.getFilePath(dataSourceUrl));
        DataSource dataSource = SqliteBuilder.create().url(dataSourceUrl).build();
        Connection connection = null;
        try {
            //Try to initialise the database
            connection = dataSource.getConnection();
            SqliteUtils.initDb(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return dataSource;
    }


    /**
     * session factory
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("dynamicDataSource") DynamicDataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        //SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().
                        getResources("classpath:mapper/**/*.xml"));
        return sessionFactoryBean.getObject();

    }

    /**
     * session template
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate ComSqlSessionTemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * dynamic data sources
     * @param dataSource
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("sqliteDataSource") DataSource dataSource){
        return new DynamicDataSource(dataSource);
    }
}
