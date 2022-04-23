import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest{
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    /*
    @Test
    public void testLinks() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "https://something.com");
        result.add(1, "some-thing.html");
        assertEquals(links, result);
    }
    */

    public void testLinks1() throws IOException{
        Path fileName = Path.of("tester.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "www.google.com");
        result.add(1, "https://cse.ucsd.edu/");
        result.add(2, "http://www.sysnet.ucsd.edu/~voelker/pubcom/logo/CSELogo_4Cv.jpg");
        assertEquals(links, result);
    }

    public void testLinks2() throws IOException{
        Path fileName = Path.of("tester2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "www.google.com");
        result.add(1, "https://cse.ucsd.edu/");
        assertEquals(links, result);
    }


    public void testLinks3() throws IOException{
        Path fileName = Path.of("tester3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "some-thing.html");
        result.add(1, "https://google.com");
        result.add(2, "some-thing.html");
        result.add(3, "https://google.com");
        result.add(4, "some-thing.html");
        assertEquals(links, result);
    }
}
