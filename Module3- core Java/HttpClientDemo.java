import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientDemo {

    public static void main(String[] args) {

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(new URI("https://api.github.com"))
                            .build();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: "
                    + response.statusCode());

            System.out.println(response.body());

        } catch(Exception e) {

            System.out.println(e);
        }
    }
}

/*
Status Code: 403
{"message":"API rate limit exceeded for 117.250.229.185. 
(But here's the good news: Authenticated requests get a higher rate limit. 
Check out the documentation for more details.)",
"documentation_url":"https://docs.github.com/rest/overview/resources-in-the-rest-api#rate-limiting"}
*/