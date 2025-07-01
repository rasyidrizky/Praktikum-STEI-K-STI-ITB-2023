public class Adventurer {
    private final String name;
    public Adventurer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        try {
            if (getClass() != o.getClass()) {
                return false;
            }
            Adventurer a = (Adventurer) o;
            return a.name.equals(this.name);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}