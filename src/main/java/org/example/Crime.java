package org.example;

import com.opencsv.bean.CsvBindByPosition;

public class Crime {
    @CsvBindByPosition(position = 1)
    private String crime;

    @CsvBindByPosition(position = 3)
    private String date;

    @CsvBindByPosition(position = 6)
    private String neighborhood;

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
