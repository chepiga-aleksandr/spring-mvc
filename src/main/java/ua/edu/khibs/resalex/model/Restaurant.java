package ua.edu.khibs.resalex.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table (name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name="id")
    private Long id;

    @Column (name="name")
    private String name;

    @Column (name = "address")
    private String address;

    @Column (name = "phone_number")
    private String phoneNumber;

    @Column (name = "e_mail")
    private String eMail;

    @Column (name = "photo")
    private String photo;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", eMail='" + eMail + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
