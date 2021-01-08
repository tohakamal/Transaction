package com.example.transactionapp;

public class model {

    String date,particulars,income,expends;

    public model(String date, String particulars, String income, String expends) {
        this.date = date;
        this.particulars = particulars;
        this.income = income;
        this.expends = expends;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getExpends() {
        return expends;
    }

    public void setExpends(String expends) {
        this.expends = expends;
    }
}
