package example.micronaut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest // <1>
public class HelloControllerTest {

  @Inject
  @Client("/") // <2>
  HttpClient client;

  @Test
  public void testHello() {
    HttpRequest<String> request = HttpRequest.GET("/hello"); // <3>
    String body = client.toBlocking().retrieve(request);

    assertNotNull(body);
    assertEquals("Hello world", body);
  }

  @Test
  public void testTest() {
    HttpRequest<String> request = HttpRequest.GET("/test"); // <3>
    String body = client.toBlocking().retrieve(request);

    assertNotNull(body);
    assertEquals("Test", body);
  }
}
