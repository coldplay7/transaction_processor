package com.demo.induction.tp.model;

public class Violation {
    private int order;
    private String property;
    private String description;

    public Violation() {
    }

    public Violation(int order, String property, String description) {
        this.order = order;
        this.property = property;
        this.description = description;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[ Order : " + this.order + " Property : " + this.property + " Description : " + this.description + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Violation)) return false;
        if (obj == this) return true;
        Violation that = (Violation) obj;
        return property.equals(that.property)
                && order == that.order
                && description.equals(that.description);
    }
}
