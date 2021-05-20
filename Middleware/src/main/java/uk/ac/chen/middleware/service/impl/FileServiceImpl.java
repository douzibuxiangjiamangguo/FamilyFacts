package uk.ac.chen.middleware.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uk.ac.chen.middleware.config.DynamicDataSource;
import uk.ac.chen.middleware.service.FileService;
import uk.ac.chen.middleware.util.SqliteBuilder;
import uk.ac.chen.middleware.util.SqliteUtils;

import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;

/**
 * @author: Qiuyu
 */
@Service("FileService")
public class FileServiceImpl implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public void createDatabase(String databaseName, String databasePath) {
        String dataSourceUrl = SqliteUtils.getDataSourceUrl(databaseName, databasePath);
        SqliteUtils.initSqliteFile(SqliteUtils.getFilePath(dataSourceUrl));
        DataSource dataSource = SqliteBuilder.create().url(dataSourceUrl).build();
        try {
            SqliteUtils.initDb(dataSource.getConnection());
        } catch (SQLException e) {
            logger.debug("An error occurred during create database: {}", e.getMessage());
            e.printStackTrace();
        }
        DynamicDataSource.addDataSource(databaseName, dataSource);
    }

    @Override
    public boolean openDatabase(String databaseName, String databasePath) {
        String dataSourceUrl = SqliteUtils.getDataSourceUrl(databaseName, databasePath);
        String filePath = SqliteUtils.getFilePath(dataSourceUrl);
        if (!SqliteUtils.checkSqliteFileExists(filePath)) {
            return false;
        }
        DataSource dataSource = SqliteBuilder.create().url(dataSourceUrl).build();
        DynamicDataSource.addDataSource(databaseName, dataSource);
        return true;
    }

    @Override
    public boolean deleteDatabase(String databaseName, String databasePath) {
        String dataSourceUrl = SqliteUtils.getDataSourceUrl(databaseName, databasePath);
        String filePath = SqliteUtils.getFilePath(dataSourceUrl);
        if (!SqliteUtils.checkSqliteFileExists(filePath)) {
            return false;
        }
        try {
            File file = new File(filePath);
            if(file.delete()) {
                logger.debug("{} is deleted!", file.getName());
                return true;
            }else {
                logger.debug("Delete operation is failed.");
                return false;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean renameDatabase(String oldName, String newName, String databasePath) {
        String dataSourceUrl = SqliteUtils.getDataSourceUrl(oldName, databasePath);
        String oldFilePath = SqliteUtils.getFilePath(dataSourceUrl);
        if (!SqliteUtils.checkSqliteFileExists(oldFilePath)) {
            return false;
        }
        String newFilePath = SqliteUtils.getFilePath(SqliteUtils.getDataSourceUrl(newName, databasePath));
        try {
            File oldFile = new File(oldFilePath);
            if (oldFile.renameTo(new File(newFilePath))) {
                logger.debug("{} is renamed!", oldFile.getName());
                return true;
            } else {
                logger.debug("Rename failed");
                return false;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
