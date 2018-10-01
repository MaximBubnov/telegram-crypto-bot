package request.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

    public static HttpURLConnection getConnection(String url) throws IOException {

        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) new URL(url).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);

            connection.connect();

            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                System.out.println("Connection create");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;

    }
}
