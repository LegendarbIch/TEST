import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class test {
    public static void main(String args[]) throws IOException {
        HHTTPCOCK hhttpcock = new HHTTPCOCK();
        hhttpcock.getServer();
        jsonCock jsonCock = new jsonCock();
        jsonCock.show();
    }
}