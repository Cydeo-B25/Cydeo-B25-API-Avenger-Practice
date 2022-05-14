package day3.zipCode;


import com.fasterxml.jackson.annotation.*;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultZip {

    @JsonProperty("post code")
    private String postCode;
    private String country;
    @JsonProperty("country abbreviation")
    private String countryAbb;
    private List<PlaceZip> places;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbb() {
        return countryAbb;
    }

    public void setCountryAbb(String countryAbb) {
        this.countryAbb = countryAbb;
    }

    public List<PlaceZip> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceZip> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "ResultZip{" +
                "postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                ", countryAbb='" + countryAbb + '\'' +
                ", places=" + places +
                '}';
    }
}
