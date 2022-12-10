package org.byt.constants;

public enum PaymentStatusEnum {
    //i suggest to have at least 3: sent, confirmed, rejected

    SENT("Payment was sent by Customer"),
    CONFIRMED("Payment was confirmed by Bank"),
    REJECTED("Payment was rejected by Bank");

    private final String description;

    PaymentStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
