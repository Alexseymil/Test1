package farm;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Farmer {
    private int id;
    private String license;
    private String firstName;
    private String lastName;
    private Date birthday;
    private List<Vegetable> vegetables;
    private List<Fertilizer> fertilizers;

    public Farmer(int id, String license, String firstName, String lastName, Date birthday, List<Vegetable> vegetables, List<Fertilizer> fertilizers) {
        this.id = id;
        this.license = license;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.vegetables = vegetables;
        this.fertilizers = fertilizers;
    }

    public Farmer(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    public List<Fertilizer> getFertilizers() {
        return fertilizers;
    }

    public void setFertilizers(List<Fertilizer> fertilizers) {
        this.fertilizers = fertilizers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farmer farmer = (Farmer) o;
        return id == farmer.id &&
                Objects.equals(license, farmer.license) &&
                Objects.equals(firstName, farmer.firstName) &&
                Objects.equals(lastName, farmer.lastName) &&
                Objects.equals(birthday, farmer.birthday) &&
                Objects.equals(vegetables, farmer.vegetables) &&
                Objects.equals(fertilizers, farmer.fertilizers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, license, firstName, lastName, birthday, vegetables, fertilizers);
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "id=" + id +
                ", license='" + license + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
//                ", vegetables=" + vegetables +
//                ", fertilizers=" + fertilizers +
                '}';
    }
}
