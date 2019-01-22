import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CookieController {
    public static void main(String[] args) throws IOException {

        List<String> request = ExtractingCookies.getRequest();

        List<HttpCookie> cookies = new ArrayList<>();


        for (String field : request) {
            if (ExtractingCookies.containsCookie(field)){
                String[] listOfCookies = field.split(": ")[1].split("; ");

                for (String c : listOfCookies) {
                    String key = c.split("=")[0];
                    String value = c.split("=")[1];

                    HttpCookie cookie = new HttpCookie(key,value);
                    cookies.add(cookie);
                }
            }
        }

        cookies.forEach(System.out::println);
    }
}
