package ua.mibal.model;

/**
 * @author Mykhailo Balakhon
 * @link <a href="mailto:mykhailo.balakhon@communify.us">mykhailo.balakhon@communify.us</a>
 */
public enum Operation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");
    
    private final String sign;

    Operation(String sign) {
        this.sign = sign;
    }

    public static Operation valueOfSign(String operation) {
        for (Operation value : values()) {
            if (value.sign.equals(operation)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown operation: " + operation);
    }
    
    
}
