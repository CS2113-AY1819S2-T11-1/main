package seedu.address.model.event;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

//@@author windrichie
/**
 * Represents an Event's title in the event calendar of events.
 * Guarantees: immutable; is valid as declared in {@link #isValidTitle(String)}
 */
public class Title {

    public static final String MESSAGE_CONSTRAINTS =
            "Title should only contain alphanumeric characters, punctuations and spaces, "
            + "and it should not be blank";

    /*
     * The first character of the title must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    // Graph refers to alphanumeric and punctuations = [\p{Alnum}\p{Punct}]
    public static final String VALIDATION_REGEX = "[\\p{Graph}][\\p{Graph} ]*";

    public final String fullTitle;

    /**
     * Constructs a {@code Title}.
     *
     * @param title A valid title.
     */
    public Title(String title) {
        requireNonNull(title);
        checkArgument(isValidTitle(title), MESSAGE_CONSTRAINTS);
        fullTitle = title;
    }

    /**
     * Returns true if a given string is a valid title.
     */
    public static boolean isValidTitle(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return fullTitle;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Title // instanceof handles nulls
                && fullTitle.equals(((Title) other).fullTitle)); // state check
    }

    @Override
    public int hashCode() {
        return fullTitle.hashCode();
    }

}
