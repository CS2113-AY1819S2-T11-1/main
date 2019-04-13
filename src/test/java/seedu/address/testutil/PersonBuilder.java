package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.modulelist.ModuleList;
import seedu.address.model.person.timetable.Activity;
import seedu.address.model.person.timetable.TimeTable;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_ACTIVITY = "S/U CS2113";
    public static final int DEFAULT_ACTIVITY_DAY = 0;
    public static final int DEFAULT_ACTIVITY_TIME = 24;
    public static final String[] DEFAULT_MODULE_LIST = {"CS2113", "CS1337"};
    public static final boolean DEFAULT_INTERLEAVE = false;

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;
    private TimeTable timeTable;
    private ModuleList moduleList;
    private boolean toBeInterleaved;

    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
        timeTable = new TimeTable();
        timeTable.add(new Activity(DEFAULT_ACTIVITY), DEFAULT_ACTIVITY_DAY, DEFAULT_ACTIVITY_TIME);
        moduleList = new ModuleList(DEFAULT_MODULE_LIST);
        toBeInterleaved = DEFAULT_INTERLEAVE;
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        tags = new HashSet<>(personToCopy.getTags());
        timeTable = personToCopy.getTimeTable();
        moduleList = personToCopy.getModules();
        toBeInterleaved = personToCopy.getInterleaved();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Timetable} of the {@code Person} that we are building.
     */
    public PersonBuilder withTimetable(int day, int time, String activity) {
        this.timeTable = new TimeTable();
        this.timeTable.add(new Activity(activity), day, time);
        return this;
    }

    /**
     * Sets the {@code ModuleList} of the {@code Person} that we are building.
     */
    public PersonBuilder withModuleList(String... modules) {
        this.moduleList = new ModuleList(modules);
        return this;
    }

    /**
     * Sets the {@code toBeInterleaved} of the {@code Person} that we are building.
     */
    public PersonBuilder withInterleaved(boolean value) {
        this.toBeInterleaved = value;
        return this;
    }

    public Person build() {
        return new Person(name, phone, email, address, tags, moduleList, timeTable);
    }

}
