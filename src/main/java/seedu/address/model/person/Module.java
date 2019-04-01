package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Module in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */


public class Module {

    public static final String TITLE_CONSTRAINS = " TITLE SHOULD BE CAPITAL LETTERS COMBINATION";

    public static final String CONTENT_CONSTRAINS = "CONTENT SHOULD BE DESCRIPTION OF THE MODULE";

    public static final String TITLE_VALIDATION_REGEX = "[\\p{Upper}][\\p{Digit}].*";

    private String title;


    private String content;

    public Module(String title, String content) {

        this.title = title;

        this.content = content;
    }

    public static boolean isValidModule(String trimmedModule) {
        return true;
    }

    public String getTitle() {
        return this.title;
    }


    public String getContent() {
        return this.content;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public boolean isValidTitle(String test) {
        return test.matches(TITLE_VALIDATION_REGEX);

    }
    public String toString () {
        return getTitle() + "\n" + "\n" + getContent();
    }

    public boolean equals (Module module1, Module module2){
        if (module1.getTitle().equals(module2.getTitle())) {
            return true;
        }
        return false;
    }

    public int hashCode (String title){
        return title.hashCode();
    }

}