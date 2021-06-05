package uk.ac.chen.middleware.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: Qiuyu
 */
public class SqliteUtils {
    private static Logger logger = LoggerFactory.getLogger(SqliteUtils.class);
    /**
     * Initialize the db file
     * @param connection
     */
    public static void initDb(Connection connection){
        //Determining whether a data table exists
        boolean hasDb = false;
        try {
            hasDb = true;
            //Test the existence of a data table
            connection.prepareStatement("select * from PersonTable").execute();
        }catch (SQLException e){
            //Non-existent
            logger.debug("table is not exist");
            hasDb = false;
        }
        //Create db if it does not exist
        if(!hasDb) {
            logger.debug(">>>start init db");
            String sql = "";
            InputStreamReader isr = null;
            try {
                ClassPathResource classPathResource = new ClassPathResource("sqlite/init.sql");
                isr = new InputStreamReader(classPathResource.getInputStream(), "UTF-8");
                BufferedReader bf = new BufferedReader(isr);
                String content = "";
                StringBuilder sb = new StringBuilder();
                while (content != null) {
                    content = bf.readLine();
                    if (content == null) {
                        break;
                    }
                    sb.append(content.trim());
                }
                sql = sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String[] sqls = sql.split(";");

            try {
                for (String str : sqls) {
                    connection.setAutoCommit(false);
                    connection.prepareStatement(str).execute();
                }
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            logger.debug("finish init db>>>");
        }else {
            logger.debug("Db is exist");
        }
    }

    public static void initDb(Connection connection,String... sqls){
        logger.debug(">>>start initDb:{}",sqls);
        try {
            for(String str:sqls) {
                connection.setAutoCommit(false);
                connection.prepareStatement(str).execute();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.debug("finish initDb>>>");
    }

    public static void initSqliteFile(String filePath){
        File file = new File(filePath);
        File dir = file.getParentFile();
        if (!dir.exists()){
            dir.mkdirs();
        }

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean checkSqliteFileExists(String filePath){
        File file = new File(filePath);
        File dir = file.getParentFile();
        if (!dir.exists()){
            logger.debug("Directory:{} not exist", filePath);
            return false;
        }
        if (!file.exists()){
            logger.debug("File:{} not exist", file.getName());
            return false;
        }
        return true;
    }

    public static String getDataSourceUrl(String databaseName, String databasePath) {
        StringBuilder dataSourceUrl = new StringBuilder("jdbc:sqlite:");
        dataSourceUrl.append(databasePath);
        if (databaseName != null && !"".equals(databaseName)) {
            dataSourceUrl.append(databaseName);
        }
        if (!databasePath.endsWith(".db")) {
            dataSourceUrl.append(".db");
        }
        return dataSourceUrl.toString();
    }

    public static String getFilePath(String url){
        url = url.replace("jdbc:sqlite:", "");
        return url;
    }
}
