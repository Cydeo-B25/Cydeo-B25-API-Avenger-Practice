package day3.hr;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {

    private String rel;
    private String href;


}
