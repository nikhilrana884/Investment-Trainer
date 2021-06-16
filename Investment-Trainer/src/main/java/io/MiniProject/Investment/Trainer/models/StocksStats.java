package io.MiniProject.Investment.Trainer.models;

public class StocksStats {

    private String Company;
    private String Last_Traded_Price;
    private String Last_Buy_Price;
    private String Last_Sell_Price;

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getLast_Traded_Price() {
        return Last_Traded_Price;
    }

    public void setLast_Traded_Price(String last_Traded_Price) {
        Last_Traded_Price = last_Traded_Price;
    }

    public String getLast_Buy_Price() {
        return Last_Buy_Price;
    }

    public void setLast_Buy_Price(String last_Buy_Price) {
        Last_Buy_Price = last_Buy_Price;
    }

    public String getLast_Sell_Price() {
        return Last_Sell_Price;
    }

    public void setLast_Sell_Price(String last_Sell_Price) {
        Last_Sell_Price = last_Sell_Price;
    }

    @Override
    public String toString() {
        return "StocksStats{" +
                "Company='" + Company + '\'' +
                ", Last_Traded_Price='" + Last_Traded_Price + '\'' +
                ", Last_Buy_Price='" + Last_Buy_Price + '\'' +
                ", Last_Sell_Price='" + Last_Sell_Price + '\'' +
                '}';
    }
}
