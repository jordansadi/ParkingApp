package edu.wctc.jsadi.Test;

import edu.wctc.jsadi.FileInput;
import org.junit.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileInputTest extends junit.framework.TestCase {
    public FileInputTest() {}

    FileInput testFile;
    BufferedReader in;

    @Before
    public void setUp() throws Exception {
        testFile = new FileInput("testFile.txt");

        in = null;
        try {
            in = new BufferedReader(new FileReader("testFile.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: " + "testFile.txt" + " " + e);
        }
    }

    @After
    public void tearDown() throws Exception {
        testFile.fileClose();
    }

    @Test
    public void testFileReadLine() {
        assertEquals("Testing for FileInput...", testFile.fileReadLine());
    }
}
