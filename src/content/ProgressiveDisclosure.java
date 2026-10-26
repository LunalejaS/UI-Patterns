package content;

public class ProgressiveDisclosure {
    private final String title;
    private final String summary;
    private final String details;
    private boolean expanded;

    public ProgressiveDisclosure(String title, String summary, String details) {
        this.title = title;
        this.summary = summary;
        this.details = details;
    }

    public void showInformation() {
        System.out.println(title);
        System.out.println(summary);
        if (!expanded) {
            System.out.println("⌃ Ver mas");
        } else {
            System.out.println(details);
            System.out.println("⌄ Ver menos");
        }
    }

    public void toggle() {
        expanded = expanded ? false : true;
    }
}