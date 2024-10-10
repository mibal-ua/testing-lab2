package ua.mibal.model;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public record Expression(
        Integer left,
        Operation operation,
        Integer right,
        boolean isEqualsPresent
) {
    public static Expression empty() {
        return new Expression(null, null, null, false);
    }
}
