package com.template.helpers.models.addresses;

import com.template.helpers.models.users.UserTitle;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.*;

public class Address implements Cloneable, Serializable {
    @Getter @Setter private UserTitle userTitle;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String street;
    @Getter @Setter private String addressLine2 = "";
    @Getter @Setter private String phoneNumber = "";
    @Getter @Setter private String city;
    @Getter @Setter private String state;
    @Getter @Setter private String zipCode;

    public Address(UserTitle userTitle, String firstName, String lastName, String address1, String city, String state, String zipCode) {
        this.userTitle = userTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = address1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + street + ", " + city + ", " + state + ", " + zipCode;
    }

    @Override
    public boolean equals(Object other) {
        if ((other == null) || !((this instanceof Address) && (other instanceof Address))) {
            return false;
        }
        Address compareObj = (Address) other;
        return new EqualsBuilder()
                .append((this.street + " " + this.addressLine2).trim(), (compareObj.street + " " + compareObj.addressLine2).trim())
                .append(this.phoneNumber, compareObj.phoneNumber)
                .append(this.city, compareObj.city)
                .append(this.state, compareObj.state)
                .append(this.zipCode, compareObj.zipCode)
                .isEquals();
    }
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append((this.street + " " + this.addressLine2).trim())
                .append(phoneNumber)
                .append(city)
                .append(state)
                .append(zipCode)
                .toHashCode();
    }

    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Address deepClone() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (Address) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
