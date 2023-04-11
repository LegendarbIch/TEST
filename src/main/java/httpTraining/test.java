package httpTraining;

import httpTraining.HttpServerCreate;
import httpTraining.jsonCock;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        HttpServerCreate hhttpcock = new HttpServerCreate();
        hhttpcock.getServer();
        jsonCock jsonCock = new jsonCock();
        jsonCock.show();
    }
}