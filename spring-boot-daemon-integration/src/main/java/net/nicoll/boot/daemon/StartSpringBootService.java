package net.nicoll.boot.daemon;

/**
 * Start a Spring Boot application as a service.
 *
 * @author Stephane Nicoll
 */
@SuppressWarnings("hideutilityclassconstructor")
public class StartSpringBootService {

    /**
     * Application Main method.
     *
     * @param args command line arguments to pass to Spring
     *
     * @throws Exception if there is an error starting the server
     */
    public static void main(final String[] args) throws Exception {
        new SpringBootService().start(args);
    }

}
