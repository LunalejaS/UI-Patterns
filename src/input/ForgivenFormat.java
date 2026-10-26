package input;

public class ForgivenFormat {

    public String normalizeFormat(String rawCellphoneNumber) {
        return removeCountryCode(rawCellphoneNumber.replaceAll("[^0-9]", ""));
    }

    public String removeCountryCode(String digits) {
        if (digits.length() == 12 && digits.startsWith("57")) {
            return digits.substring(2);
        }
        return digits;
    }

    public boolean isValid(String digits) {
        return digits.length() == 10 && digits.startsWith("3");
    }

    public String formatNumber(String digits) {
        return digits.substring(0, 3) + " " + digits.substring(3, 6) + " " + digits.substring(6);
    }
}