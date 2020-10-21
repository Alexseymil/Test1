package farm;

import java.util.Objects;

public class Vegetable {
    private int id;
    private String name;
    private int ageDays;

    public Vegetable() {}

    public Vegetable(int id, String name, int ageDays) {
        this.id = id;
        this.name = name;
        this.ageDays = ageDays;
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

    public int getAgeDays() {
        return ageDays;
    }

    public void setAgeDays(int ageDays) {
        this.ageDays = ageDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vegetable vegetable = (Vegetable) o;
        return id == vegetable.id &&
                ageDays == vegetable.ageDays &&
                Objects.equals(name, vegetable.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ageDays);
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ageDays=" + ageDays +
                '}';
    }
}
