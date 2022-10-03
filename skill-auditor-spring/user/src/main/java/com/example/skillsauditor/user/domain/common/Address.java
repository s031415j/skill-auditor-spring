package com.example.skillsauditor.user.domain.common;

import lombok.ToString;

@ToString
public class Address extends ValueObject {

    private String houseNameNumber;
    private String street;
    private String town;
    private String postcode;


    public Address(String houseNameNumber, String street, String town, String postcode) {
        this.houseNameNumber = houseNameNumber;
        this.street = street;
        this.town = town;
        this.postcode = postcode;
    }

    public boolean equals(Object o) {
        if (o == null && o.getClass() != this.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return address.houseNameNumber.equals(this.houseNameNumber) && address.street.equals(this.street) && address.town.equals(this.town) && address.postcode.equals(this.postcode);
    }

    private void setHouseNameNumber(String houseNameNumber){
        this.assertArgumentNotEmpty(houseNameNumber,"House name/number cannot be empty");
        this.assertArgumentLength(houseNameNumber, 1,50,"House name/number must be no more than 50 characters");
        this.houseNameNumber = houseNameNumber;
    }

    private void setStreet(String street){
        this.assertArgumentNotEmpty(street,"Street cannot be empty");
        this.assertArgumentLength(street, 1,50,"Street must be no more than 50 characters");
        this.street = street;
    }

    private void setTown(String town){
        this.assertArgumentNotEmpty(town,"Town cannot be empty");
        this.assertArgumentLength(town, 1,30,"Town must be no more than 30 characters");
        this.town = town;
    }

    private void setPostcode(String postcode){
        this.assertArgumentNotEmpty(postcode,"Postcode cannot be empty");
        this.assertArgumentLength(postcode, 1,30,"Town must be no more than 30 characters");
        this.town = town;
    }

    public String getHouseNameNumber(){
        return houseNameNumber;
    }

    public String getStreet(){
        return street;
    }

    public String getTown(){
        return town;
    }

    public String getPostcode(){
        return postcode;
    }

    public String toString(){
        return String.format("s% %s %s %s", houseNameNumber, street, town, postcode);
    }

}
