package utp.restaurant.model;

public record Category(long id, String name, String description) {
    @Override
    public String toString() {
        return name;
    }
}
