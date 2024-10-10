package ua.mibal.model;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public record Expression(
        int left,
        Operation operation,
        int right,
        boolean isEqualsPresent
) {
}
