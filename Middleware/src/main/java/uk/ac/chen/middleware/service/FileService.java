package uk.ac.chen.middleware.service;

/**
 * @author: Qiuyu
 */
public interface FileService {

    /**
     * Create a new database file
     * @param databaseName name
     * @param databasePath path
     */
    void createDatabase(String databaseName, String databasePath);

    /**
     * Open a database file
     * @param databaseName name
     * @param databasePath path
     * @return Ture if ok, false if the file dose not exist
     */
    boolean openDatabase(String databaseName, String databasePath);

    /**
     * Delete database
     * @param databaseName name
     * @param databasePath path
     * @return Ture if the deletion is successful,
     * false if the file does not exist or delete operation is failed.
     */
    boolean deleteDatabase(String databaseName, String databasePath);

    /**
     * Rename the database
     * @param oldName old name
     * @param newName new name
     * @param databasePath path
     * @return Ture if rename operation is successful,
     * false if the file does not exist or rename operation is failed.
     */
    boolean renameDatabase(String oldName, String newName, String databasePath);
}


