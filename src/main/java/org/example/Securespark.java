package org.example;

import static spark.Spark.*;


public class Securespark {
    public static void main(String[] args) {

        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystore/ecikeystore.p12", "eci123", null, null);
        get("/hello", (req, res) -> "Hello World");
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}