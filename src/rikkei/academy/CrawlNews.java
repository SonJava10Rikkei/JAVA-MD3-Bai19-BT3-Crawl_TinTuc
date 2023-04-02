package rikkei.academy;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content1 = scanner.next();
            scanner.close();
            content1 = content1.replaceAll("\\n+", "");

            Pattern p = Pattern.compile("article-title\">(.*?)</h3>");
            Matcher m = p.matcher(content1);
            while (m.find()) {
                String text = m.group(1);
                String[] textArr = text.split(".htm\">");
                String finalText = textArr[1].replaceAll("</a>", "");
                finalText = finalText.replaceAll("&quot;", "\"");
                System.out.println(finalText);
            }
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        } catch (
                UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
