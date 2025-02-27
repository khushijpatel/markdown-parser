//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//Taken from CSE15L lab partner (Jeff)

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            /*
            String returnedStr;
            int start;
            int end;

            // Determine the checked indices
            if (currentIndex == 0) {
                start = currentIndex;
                end = currentIndex + 1;
                
            } else {
                start = openBracket - 1;
                end = openBracket;
            }

            // Check if there is a ! before []
            if (markdown.substring(start, end).equals("!") == false) {
                returnedStr = markdown.substring(openParen + 1, closeParen);

                // Remove extra spaces if present
                returnedStr = returnedStr.replaceAll(" ", "");

                // Check if the string is empty
                if (returnedStr.equals("") == false) {
                    toReturn.add(returnedStr);
                }
            }
            */

            if (openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1){
                return toReturn;
            }
            //check to make sure that "]" and "(" are side by side
            if (closeBracket != openParen -1){
                return toReturn;
            }
            //to distinguish between image and link syntax
            if (openBracket == 0){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
            else if (markdown.substring(openBracket-1, openBracket).equals("!")){
                currentIndex = closeParen + 1;
                continue;
            }
            //if it is 100% a link, add it to the list
            else{
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }

            //currentIndex = closeParen + 1;
        }

        return toReturn;
        
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
