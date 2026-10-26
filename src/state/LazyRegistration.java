package state;

public class LazyRegistration {
    private boolean registered;
    private String userName;

    public LazyRegistration() {
        this.registered = false;
        this.userName = "Invitado";
    }

    public boolean isRegistered() {
        return registered;
    }

    public String getUserName() {
        return userName;
    }

    public void register(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("-> El nombre no puede estar vacío.");
        }
        this.userName = userName.trim();
        this.registered = true;
    }
}
