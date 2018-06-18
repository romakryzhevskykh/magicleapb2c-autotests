package com.sarnova.helpers.models.delivery_methods;

public enum DeliveryMethod {
    DAY_2ND("2ndDay", "2-Day", "Customer service will provide an estimate"),
    GROUND("ground", "Ground","1-3 business days"),
    OVERNIGHT("overnight", "Overnight","Customer service will provide an estimate");

    private final String nameInCheckoutHTML;
    private final String nameOnConfirmationPage;
    private final String explanation;

    DeliveryMethod(String nameInCheckoutHTML, String nameOnConfirmationPage, String explanation) {
        this.nameInCheckoutHTML = nameInCheckoutHTML;
        this.nameOnConfirmationPage = nameOnConfirmationPage;
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getNameInCheckoutHTML() {
        return nameInCheckoutHTML;
    }

    public String getNameOnConfirmationPage() {
        return nameOnConfirmationPage;
    }
}
