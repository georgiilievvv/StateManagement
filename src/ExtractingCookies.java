import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;

public class ExtractingCookies {
    public static void main(String[] args) throws IOException {

        List<String> request = getRequest();

        for (String field : request) {
            if (containsCookie(field)){
                String[] cookies = field.split(": ")[1].split("; ");
                List<String> nameValue = new ArrayList<>();

                for (String cookie : cookies) {
                    nameValue.add(cookie.replace("="," <-> "));
                }

                nameValue.forEach(System.out::println);
            }
        }

    }

    static boolean containsCookie(String field) {
        return field.startsWith("Cookie");
    }

    static List<String> getRequest() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> request = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null && line.length() > 0) {
            request.add(line);
        }

        if ((line = reader.readLine()) != null && line.length() > 0) {
            request.add("");
        }

        request.add(line);

        return request;
    }
}
