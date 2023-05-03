public class Agents {
    private String name;
    private String role;

    public Agents(String name, String role) {
        this.setName(name);
        this.setRole(role);
    }

    @Override
    public String toString() {
        return "Agents{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null||name.isEmpty())
            throw new IllegalArgumentException();
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role==null||role.isEmpty())
            throw new IllegalArgumentException("Agent role is not given");
        this.role = role;
    }
}
