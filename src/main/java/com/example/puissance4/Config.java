package com.example.puissance4;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Configuration class for setting up beans commonly used throughout the Puissance 4 application.
 * This class defines beans for standard input and output streams and internationalization message sources.
 */
@Configuration
public class Config {

    /**
     * Creates a bean that provides the standard input stream.
     * This bean can be injected wherever an InputStream is required in the application,
     * facilitating easier testing and redirection of input sources.
     *
     * @return The standard input stream, typically {@code System.in}.
     */
    @Bean
    public InputStream getInputStream() {
        return System.in;
    }

    /**
     * Creates a bean that provides the standard output stream.
     * This bean allows for consistent use of the output stream across the application,
     * enabling redirection or different handling of output as necessary.
     *
     * @return The standard output stream, typically {@code System.out}.
     */
    @Bean
    public OutputStream getOutputStream() {
        return System.out;
    }

    /**
     * Configures the message source for internationalization.
     * This bean manages message localization, allowing the application to support multiple languages
     * by defining properties files under the "locale" basename.
     *
     * @return A MessageSource that handles message localization based on the set basename and default encoding.
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("locale");  // Set the basename of the resource bundles used for localization.
        messageSource.setDefaultEncoding("UTF-8");  // Use UTF-8 encoding for resource bundle properties files.

        return messageSource;
    }
}
