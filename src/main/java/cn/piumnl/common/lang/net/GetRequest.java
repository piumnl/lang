package cn.piumnl.common.lang.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * @author piumnl
 * @version 1.0.0
 * @since on 2017-05-08.
 */
public class GetRequest {
    public static String INPUTSTREAM_CHARSET = "UTF-8";

    private URL url;

    private URLConnection connection;

    private InputStream inputStream;

    private OutputStream outputStream;

    public GetRequest(URL url) {
        this.url = url;
    }

    public void start() {
        try {
            connection = url.openConnection();
            setRequestProperty();
            connection.connect();

            inputStream = connection.getInputStream();
            //      outputStream = connection.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setRequestProperty() {
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
    }

    public InputStreamReader getReader() {
        return new InputStreamReader(inputStream, Charset.forName(INPUTSTREAM_CHARSET));
    }
}
