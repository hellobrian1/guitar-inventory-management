package c322spring2024homework2.c322spring2024homework2.enums;

public enum TypeEnum {
    ACOUSTIC, ELECTRIC, ANY;

    public String toString() {
        switch(this) {
            case ACOUSTIC: return "Acoustic";
            case ELECTRIC: return "Electric";
            case ANY: return "Any";
            default: return "Unspecified";
        }
    }
}
