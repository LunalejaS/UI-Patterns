package state;

import java.util.LinkedHashMap;
import java.util.Map;

public class CompletenessMeter {

    private static final int BAR_LENGTH = 10;

    private final Map<String, Boolean> fields = new LinkedHashMap<>();

    public CompletenessMeter(String... fieldNames) {
        if (fieldNames == null || fieldNames.length == 0) {
            throw new IllegalArgumentException("-> Debe existir al menos un campo.");
        }
        for (String name : fieldNames) {
            fields.put(name, false);
        }
    }

    public void markCompleted(String fieldName) {
        validateField(fieldName);
        fields.put(fieldName, true);
    }

    public void markPending(String fieldName) {
        validateField(fieldName);
        fields.put(fieldName, false);
    }

    public int getPercentage() {
        int completed = 0;
        for (boolean done : fields.values()) {
            if (done) {
                completed++;
            }
        }
        return completed * 100 / fields.size();
    }

    public String render() {
        int percentage = getPercentage();
        int filled = percentage * BAR_LENGTH / 100;
        return "Progreso: [" + "#".repeat(filled) + "-".repeat(BAR_LENGTH - filled) + "] " + percentage + "%";
    }

    private void validateField(String fieldName) {
        if (!fields.containsKey(fieldName)) {
            throw new IllegalArgumentException("-> El campo '" + fieldName + "' no existe en el formulario.");
        }
    }
}