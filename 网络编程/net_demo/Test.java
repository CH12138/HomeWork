package net_demo;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://blog.csdn.net/softimes/article/details/7225879");

//        打开与此 URL ，并返回一个 InputStream ，以便从该连接读取。
        InputStream inputStream = url.openStream();
        BufferedReader br = new BufferedReader( new InputStreamReader(inputStream,"utf-8"));
        File file = new File("F://网页.txt");
        OutputStream outputStream = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(outputStream));

        int a = inputStream.available();
        System.out.println(a);
        String s = "";
        while ((s = br.readLine()) != null)
        {
            System.out.println(s);
            bw.write(s);
        }
    }
}
