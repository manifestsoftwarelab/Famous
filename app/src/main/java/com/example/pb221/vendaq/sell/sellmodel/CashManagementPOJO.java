package com.example.pb221.vendaq.sell.sellmodel;

/**
 * Created by pb221 on 28-10-2017.
 */

public class CashManagementPOJO {
    private String cashTime;

    public String getCashTime() {
        return cashTime;
    }

    public void setCashTime(String cashTime) {
        this.cashTime = cashTime;
    }


    public String getCashReasons() {
        return cashReasons;
    }

    public void setCashReasons(String cashReasons) {
        this.cashReasons = cashReasons;
    }

    public String getCashTransactionAmount() {
        return cashTransactionAmount;
    }

    public void setCashTransactionAmount(String cashTransactionAmount) {
        this.cashTransactionAmount = cashTransactionAmount;
    }

    public CashManagementPOJO(String cashTime, String cashManagerName, String cashManagerEmail, String cashReasons, String cashTransactionAmount) {
        this.cashTime = cashTime;
        this.cashManagerName = cashManagerName;
        this.cashManagerEmail = cashManagerEmail;
        this.cashReasons = cashReasons;
        this.cashTransactionAmount = cashTransactionAmount;
    }

    public String getCashManagerName() {
        return cashManagerName;
    }

    public void setCashManagerName(String cashManagerName) {
        this.cashManagerName = cashManagerName;
    }

    public String getCashManagerEmail() {
        return cashManagerEmail;
    }

    public void setCashManagerEmail(String cashManagerEmail) {
        this.cashManagerEmail = cashManagerEmail;
    }

    private String cashManagerName;
    private String cashManagerEmail;
    private String cashReasons;

    private String cashTransactionAmount;
}
