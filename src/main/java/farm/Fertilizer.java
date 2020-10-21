package farm;

import java.util.Objects;

public class Fertilizer {
    private int id;
    private String name;
    private boolean organic;

    public Fertilizer(){}

    public Fertilizer(int id, String name, boolean organic){
        this.id = id;
        this.name = name;
        this.organic = organic;
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

    public boolean isOrganic() {
        return organic;
    }

    public void setOrganic(boolean organic) {
        this.organic = organic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fertilizer that = (Fertilizer) o;
        return id == that.id &&
                organic == that.organic &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, organic);
    }

    @Override
    public String toString() {
        return "Fertilizer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organic=" + organic +
                '}';
    }
}
