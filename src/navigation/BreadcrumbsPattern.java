package navigation;

import java.util.List;
import java.util.ArrayList;

// Breadcrumbs are an important navigational element that supports wayfinding, making user aware of their current location within the hierarchical structure of a website.
public class BreadcrumbsPattern {
    private final List<String> trail = new ArrayList<>();

    public BreadcrumbsPattern(String home) {
        trail.add(home);
    }

    public void navigateTo(String screenName) {
        if (trail.contains(screenName)) {
            goBackTo(trail.indexOf(screenName));
        } else {
            trail.add(screenName);
        }
    }

    public String render() {
        return String.join(">", trail);
    }

    public void goBackTo(int index) {
         if (index < 0 || index >= trail.size()) {
            System.out.println(" -> El indice al que se desea ir no esta disponible.");
            return;
        }
        trail.subList(index + 1, trail.size()).clear();
    }
}