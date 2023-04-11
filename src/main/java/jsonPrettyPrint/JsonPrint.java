package jsonPrettyPrint;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class JsonPrint {

    public static void main(String[] args) throws IOException {
        JsonPrint jsonPrint = new JsonPrint();
        jsonPrint.print();
        jsonPrint.getLinesFromFile();
    }

    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\IdeaProjects\\TEST\\src\\main\\java\\jsonPrettyPrint\\vpn.json"));

    public JsonPrint() throws FileNotFoundException {
    }

    public String print() throws IOException {
        return getLinesFromFile().replaceAll(",","\n");
    }

    public String getLinesFromFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        String line = br.lines().collect(Collectors.joining());
        return line;
    }
}
