package net.nicoll.boot.daemon;

/**
 * Stop a Spring Boot application as a service.
 *
 * @author Stephane Nicoll
 */
@SuppressWarnings("hideutilityclassconstructor")
public class StopSpringBootService {

    /**
     * Application Main method.
     *
     * @param args command line arguments to pass to Spring
     *
     * @throws Exception if there is an error starting the server
     */
    public static void main(final String[] args) throws Exception {
        new SpringBootService().stop(args);
    }

}
