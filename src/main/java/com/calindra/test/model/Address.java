package com.calindra.test.model;

import java.util.ArrayList;
import java.util.List;

public class Address {
    List<String> addresses;

    public Address() {}

    public Address(List<String> addresses) {
        this.addresses = addresses;
    }

    public List<String> getAddresses() {
        return addresses;
    }
}
