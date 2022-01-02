package com.weelo.demoqa.exceptions;

public class AssertionsDemoqa extends AssertionError {

    private static final long serialVersionUID = 1L;

    public static final String NO_FOUND_ELEMENT = "El elemento a verificar no es visible";
    public static final String COLOR_BORDER_FIELD_NO_EXPECTED = "El color del border del campo no es el esperado";

    public AssertionsDemoqa(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionsDemoqa(String message) {
        super(message);
    }

}
