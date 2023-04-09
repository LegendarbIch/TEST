package httpTraining;

import httpTraining.HHTTPCOCK;
import httpTraining.jsonCock;

import java.io.IOException;

public class test {
    public static void main(String args[]) throws IOException {
        HHTTPCOCK hhttpcock = new HHTTPCOCK();
        hhttpcock.getServer();
        jsonCock jsonCock = new jsonCock();
        jsonCock.show();
    }
}