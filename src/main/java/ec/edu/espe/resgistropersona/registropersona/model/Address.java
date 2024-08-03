package ec.edu.espe.resgistropersona.registropersona.model;

import lombok.Data;

@Data //coloca getters y setters

public class Address {
    private String principalStreet;
    private String secondaryStreet;
    private String houseNumber;
    private String reference;
    private String city;
    private String postalCode;
    private String addressType;


}
