package seedu.address.logic.commands;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.Event;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;

public class AddModuleCommand {
    public static final String COMMAND_WORD = "addModule";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds and Module to the Time Table"
            + "Parameters: "
            + PREFIX_TITLE + "TITLE "
            + PREFIX_DATE + "DATE "
            + PREFIX_TIME + "TIME "
            + PREFIX_VENUE + "VENUE "
            + "[" + PREFIX_TARGETAUDIENCE + "AUDIENCE] "
            + "[" + PREFIX_DRESSCODE + "DRESSCODE] "
            + "[" + PREFIX_DESCRIPTION + "DESCRIPTION]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TITLE + "CS101"
            + PREFIX_DATE + "01/04/2019"
            + PREFIX_TIME + "OFFICIAL TIME SUCH AS 15:00 - 16: 00"
            + PREFIX_VENUE + "COM2"
            + "[" + PREFIX_TARGETAUDIENCE + "ALL STUDENTS] "
            + "[" + PREFIX_DRESSCODE + "ANYTHING YOU WANT] "
            + "[" + PREFIX_DESCRIPTION + "THIS MODULE IS ABOUT.]...\n";

    public static final String MESSAGE_SUCCESS = "New event added: %1$s";
    public static final String MESSAGE_DUPLICATE_EVENT = "This event already exists in the events calendar";

    public final Module toAdd;


    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddModuleCommand(Module module) {
        requireNonNull(module);
        toAdd = module;
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddModuleCommand // instanceof handles nulls
                && toAdd.equals(((AddModuleCommand) other).toAdd));
    }

}
