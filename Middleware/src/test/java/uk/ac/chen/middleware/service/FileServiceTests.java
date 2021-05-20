package uk.ac.chen.middleware.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: Qiuyu
 */
@SpringBootTest
public class FileServiceTests {
    @Resource
    private FileService fileService;

    @Test
    void testCreateDatabase() {
        String databaseName = "fileTest";
        String databasePath = "/Users/chen/Desktop/Newcastle/Dissertation/" +
                "code/FamilyFacts/Middleware/src/main/resources/sqlite/";
        fileService.createDatabase(databaseName, databasePath);
    }

    @Test
    void testOpenDatabase() {
        String databaseName = "fileTest";
        String databasePath = "/Users/chen/Desktop/Newcastle/Dissertation/" +
                "code/FamilyFacts/Middleware/src/main/resources/sqlite/";
        Assertions.assertTrue(fileService.openDatabase(databaseName, databasePath));
    }

    @Test
    void renameDatabase() {
        String oldName = "fileTest";
        String newName = "newFileTest";
        String databasePath = "/Users/chen/Desktop/Newcastle/Dissertation/" +
                "code/FamilyFacts/Middleware/src/main/resources/sqlite/";
        Assertions.assertTrue(fileService.renameDatabase(oldName, newName, databasePath));
    }

    @Test
    void testDeleteDatabase() {
        String databaseName = "newFileTest";
        String databasePath = "/Users/chen/Desktop/Newcastle/Dissertation/" +
                "code/FamilyFacts/Middleware/src/main/resources/sqlite/";
        Assertions.assertTrue(fileService.deleteDatabase(databaseName, databasePath));
    }

}
