package com.pmb.PayMyBuddy.constants;

public enum TransactionType {
    TRANSFER ("TRANSFER") ,PAYMENT("PAYMENT");
    private final String transactionType;


    TransactionType(String type) {
        this.transactionType = type;
    }

    public String getTransactionType() {
        return this.transactionType;
    }
}
