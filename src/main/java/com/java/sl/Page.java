package com.java.sl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Page {
    /*
    抓取网页
     */
    public String fetch(URL url){
        StringBuffer htmlBuffer = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            while(line != null){
                line = reader.readLine();
                htmlBuffer.append(line);
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return htmlBuffer.toString();
    }

    public String fetch(String url) throws Exception{
        String html = new String();
        try{
            URL inUrl = new URL(url);
            html = fetch(inUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
        return html;
    }
}
