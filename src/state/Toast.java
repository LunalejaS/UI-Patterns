package state;

import java.util.ArrayDeque;
import java.util.Queue;

public class Toast {

    public enum Type {
        SUCCESS("✔"),
        ERROR("✖"),
        INFO("ℹ");

        private final String icon;

        Type(String icon) {
            this.icon = icon;
        }

        public String getIcon() {
            return icon;
        }
    }

    private final Queue<String> pending = new ArrayDeque<>();

    public void push(Type type, String message) {
        if (type == null) {
            throw new IllegalArgumentException("-> El tipo de mensaje no puede ser nulo.");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("-> El mensaje no puede estar vacío.");
        }
        pending.add("[" + type.getIcon() + "] " + message.trim());
    }

    public boolean hasPending() {
        return !pending.isEmpty();
    }

    public String next() {
        if (pending.isEmpty()) {
            throw new IllegalStateException("-> No hay mensajes pendientes.");
        }
        return pending.poll();
    }
}