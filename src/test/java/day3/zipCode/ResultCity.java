package day3.zipCode;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultCity{
    @JsonProperty("country abbreviation")
    private String countryAbb;

    private List<PlaceCity> places;

    private String country;

    @JsonProperty("place name")
    private String placeName;

    private String state;

    @JsonProperty("state abbreviation")
    private String stateAbb;



}
