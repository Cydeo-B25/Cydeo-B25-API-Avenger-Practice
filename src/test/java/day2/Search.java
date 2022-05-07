package day2;

import java.util.*;

public class Search {

    private List<Spartan> spartanList;
    private int total;

    public List<Spartan> getSpartanList() {
        return spartanList;
    }

    public void setSpartanList(List<Spartan> spartanList) {
        this.spartanList = spartanList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Search{" +
                "spartanList=" + spartanList +
                ", total=" + total +
                '}';
    }
}
