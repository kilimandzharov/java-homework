package com.kirillmozharov.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User {
    /**
     * {
     *     "id": 1,
     *     "name": "Leanne Graham",
     *     "username": "Bret",
     *     "email": "Sincere@april.biz",
     *     "address": {
     *       "street": "Kulas Light",
     *       "suite": "Apt. 556",
     *       "city": "Gwenborough",
     *       "zipcode": "92998-3874",
     *       "geo": {
     *         "lat": "-37.3159",
     *         "lng": "81.1496"
     *       }
     *     },
     *     "phone": "1-770-736-8031 x56442",
     *     "website": "hildegard.org",
     *     "company": {
     *       "name": "Romaguera-Crona",
     *       "catchPhrase": "Multi-layered client-server neural-net",
     *       "bs": "harness real-time e-markets"
     *     }
     *   },
     */
    private int id;
    private String name;
    @JsonProperty("username")
    private String userName;
    private String email;
    private String phone;
    private String website;
    private Address address;
    private Company company;
    public User() {
    }

    public User(int id, String name, String userName, String email, String phone, String website, Address address, Company company) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.address = address;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(userName, user.userName) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(website, user.website) && Objects.equals(address, user.address) && Objects.equals(company, user.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userName, email, phone, website, address, company);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", address=" + address +
                ", company=" + company +
                '}';
    }
}
