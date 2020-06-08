package com.demo.induction.tp.model;

import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

public class Transaction {

    private String type;
    private BigDecimal amount;
    private String narration;

    public Transaction() {
    }

    public Transaction(String type, BigDecimal amount, String narration) {
        this.type = type;
        this.amount = amount;
        this.narration = narration;
    }

    public String getType() {
        return type;
    }

    @XmlAttribute
    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @XmlAttribute
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNarration() {
        return narration;
    }

    @XmlAttribute
    public void setNarration(String narration) {
        this.narration = narration;
    }

    @Override
    public String toString() {
        return "[ Type = " + this.type + "]" + " [" + " Amount =" + this.amount + " [ Narration = " + this.narration + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Transaction)) return false;
        if (o == this) return true;
        Transaction that = (Transaction) o;
        return (amount.compareTo(that.amount) == 0)
                && (type.equals(that.type))
                && (narration.equals(that.narration));
    }

}
