package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PDF {

    public static void main(String[] args) {
        File dir = new File("C:\\PDF");
        if (!dir.exists()) {
            dir.mkdir();
        }


        String url = "https://drive.google.com/uc?export=download&id=1ufJ4UPNscvjd0whIjs28bz_lRtgm2NTS";
        String filename = "javaEE.pdf";
        File file = new File(dir, filename);
        try {
            URL myURL = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
            InputStream is = conn.getInputStream();
            FileOutputStream fos = new FileOutputStream(file);

            System.out.println("file: " + filename + " downloading kick-off!");

            int length = 0;
            byte[] b = new byte[4096];    // 每次讀到的資料量不一定
            while ((length = is.read(b)) != -1) {
                // b: 代表要輸出的byte陣列 (資料都放在裡面了)
                // 0: 代表從這個陣列的第一個元素開始輸出 (索引值)
                // length: 代表要輸出的資料量
                fos.write(b, 0, length);
                fos.flush(); //強制輸出
            }

            fos.close();
            is.close();
            System.out.println(filename + " Done!");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
