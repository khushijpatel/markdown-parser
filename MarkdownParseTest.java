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

    public void testLinks1() throws IOException{
        Path fileName = Path.of("tester2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "www.google.com");
        result.add(1, "https://cse.ucsd.edu/");
        assertEquals(links, result);
    }
}
