package org.example.lab3.Model;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * A class designed to decorate a person object with aditional information about the Person.
 * This class extends the PersonDecorator class to add functionality to message method. This decorator adds age and birthday.
 */
public class AgeDecorator extends PersonDecorator {
    private final Person decoratedPerson;

    /**
     * Private constructor for AgeDecorator
     * @param builder Builder
     */
    private AgeDecorator(AgeDecorator.Builder builder) {
        super(builder.personInterface);
        this.decoratedPerson = builder.person;
    }

    /**
     * Gets birthday month in lithuanian for the person.
     * @return Month in lithuanian.
     */
    public String getMonth() {
        return switch (decoratedPerson.getBirth_date().getValue().getMonthValue()) {
            case 1 -> "Sausio";
            case 2 -> "Vasario";
            case 3 -> "Kovo";
            case 4 -> "Balandžio";
            case 5 -> "Gegužės";
            case 6 -> "Birželio";
            case 7 -> "Liepos";
            case 8 -> "Rugpjūčio";
            case 9 -> "Rugsėjo";
            case 10 -> "Spalio";
            case 11 -> "Lapkričio";
            case 12 -> "Gruodžio";
            default -> "";
        };
    }

    /**
     * Adds additional content to the message.
     * @return the message from the decorated person concatenated with new information.
     */
    @Override
    public String message() {
        return super.message() + "Jūs esate gimę " + getMonth() + " " + decoratedPerson.getBirth_date().getValue().getDayOfMonth() + " dieną. ";
    }

    /**
     * @author Julius Jauga 5 gr. 1 pogr.
     * Builder class for AgeDecorator.
     */
    public static class Builder {
        Person person;
        PersonInterface personInterface;

        /**
         * Adding PersonInterface to Decorator.
         * @param personInterface PersonInterface object.
         * @return Builder to AgeDecorator class.
         */
        public AgeDecorator.Builder withDecorator(PersonInterface personInterface) {
            this.personInterface = personInterface;
            return this;
        };
        /**
         * Adding Person to Decorator.
         * @param person Person object.
         * @return Builder to AgeDecorator class.
         */
        public AgeDecorator.Builder withPerson(Person person) {
            this.person = person;
            return this;
        }
        /**
         * Building the object.
         * @return new AgeDecorator.
         */
        public AgeDecorator build() {
            return new AgeDecorator(this);
        }
    }
}
