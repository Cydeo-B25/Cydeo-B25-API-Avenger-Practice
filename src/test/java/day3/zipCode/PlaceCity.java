package day3.zipCode;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceCity {

    @JsonProperty("place name")
    private String placeName;
    private String longitude;
    @JsonProperty("post code")
    private String postCode;
    private String latitude;


}
