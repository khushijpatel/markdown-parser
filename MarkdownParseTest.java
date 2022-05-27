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
        Path fileName = Path.of("C:\\Users\\K Patel\\Documents\\GitHub\\markdown-parser\\test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "https://something.com");
        result.add(1, "some-thing.html");
        assertEquals(links, result);
    }

    @Test
    public void testLinks1() throws IOException{
        Path fileName = Path.of("C:\\Users\\K Patel\\Documents\\GitHub\\markdown-parser\\tester.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "www.google.com");
        result.add(1, "  https://cse.ucsd.edu/");
        assertEquals(links, result);
    }

    @Test
    public void testLinks2() throws IOException{
        Path fileName = Path.of("C:\\Users\\K Patel\\Documents\\GitHub\\markdown-parser\\tester2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "www.google.com");
        result.add(1, "  https://cse.ucsd.edu/");
        assertEquals(links, result);
    }

    @Test
    public void testLinks3() throws IOException{
        Path fileName = Path.of("C:\\Users\\K Patel\\Documents\\GitHub\\markdown-parser\\tester3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "some-thing.html");
        result.add(1, "https://google.com");
        result.add(2, "some-thing.html");
        result.add(3, "https://google.com");
        result.add(4, " some-thing.html ");
        assertEquals(links, result);
    }

    @Test
    public void testLinks4() throws IOException{
        Path fileName = Path.of("C:\\Users\\K Patel\\Documents\\GitHub\\markdown-parser\\snippet1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "url.com");
        result.add(1, "`google.com");
        result.add(2, "google.com");
        assertEquals(links, result);
    }

    @Test
    public void testLinks5() throws IOException{
        Path fileName = Path.of("C:\\Users\\K Patel\\Documents\\GitHub\\markdown-parser\\snippet2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "b.com");
        result.add(1, "a.com(())");
        result.add(2, "example.com");
        assertEquals(links, result);
    }

    @Test
    public void testLinks6() throws IOException{
        Path fileName = Path.of("C:\\Users\\K Patel\\Documents\\GitHub\\markdown-parser\\snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>();
        result.add(0, "https://www.twitter.com");
        result.add(1, "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        result.add(2, "https://cse.ucsd.edu/");
        assertEquals(links, result);
    }
}
