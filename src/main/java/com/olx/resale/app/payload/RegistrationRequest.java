package com.olx.resale.app.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegistrationRequest {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Name is mandatory")
    @Email(message = "Enter valid email")
    private String email;

    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Enter 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password should be greater than 6 character")
    private String password;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password should be greater than 6 character")
    private String confirmPassword;
    @NotBlank(message = "City is mandatory")
    private String city;
    @NotBlank(message = "State is mandatory")
    private String state;
    @NotBlank(message = "Country is mandatory")
    private String country;
    @NotBlank(message = "Pin code is mandatory")
    @Size(min=6, message = "Enter valid pin code")
    private String pincode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
