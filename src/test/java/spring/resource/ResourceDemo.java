package spring.resource;

import org.junit.Test;

import java.net.URI;
import java.net.URL;

import static junit.framework.Assert.assertEquals;

public class ResourceDemo {
    @Test
    public void whenCreatingURIs_thenSameInfo() throws Exception {
        URI firstURI = new URI(
                "somescheme://theuser:thepassword@someauthority:80"
                        + "/some/path?thequery#somefragment");

        URI secondURI = new URI(
                "somescheme", "theuser:thepassword", "someuthority", 80,
                "/some/path", "thequery", "somefragment");

        assertEquals(firstURI.getScheme(), secondURI.getScheme());
        assertEquals(firstURI.getPath(), secondURI.getPath());
    }

    @Test
    public void whenCreatingURLs_thenSameInfo() throws Exception {
        URL firstURL = new URL(
                "http://theuser:thepassword@somehost:80"
                        + "/path/to/file?thequery#somefragment");
        URL secondURL = new URL("http", "somehost", 80, "/path/to/file");

        assertEquals(firstURL.getHost(), secondURL.getHost());
        assertEquals(firstURL.getPath(), secondURL.getPath());
    }
}
