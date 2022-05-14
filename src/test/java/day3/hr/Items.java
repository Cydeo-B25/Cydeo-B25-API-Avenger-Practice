package day3.hr;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {

    private List<ResultJobs> items;


}
