package vask.ostock.licenseservice.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;
@Data
@ToString
public class Organization extends RepresentationModel<Organization> {

    String id;
    String name;
    String contactName;
    String contactEmail;
    String contactPhone;

}
