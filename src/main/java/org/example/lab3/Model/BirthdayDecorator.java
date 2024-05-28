package org.example.lab3.Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * A class designed to decorate a person object with aditional information about the Person.
 * This class extends the PersonDecorator class to add functionality to message method. This decorator calculates next birthday.
 */
public class BirthdayDecorator extends PersonDecorator {
    private final Person decoratedPerson;
    /**
     * Private constructor for Birhday decorator
     * @param builder Builder
     */
    private BirthdayDecorator(BirthdayDecorator.Builder builder) {
        super(builder.personInterface);
        this.decoratedPerson = builder.person;
    }
    /**
     * Adds additional content to the message.
     * @return the message from the decorated person concatenated with new information.
     */
    @Override
    public String message() {
        String message = super.message() + "Jūsų gimtadienis yra ";
        int month = decoratedPerson.getBirth_date().getValue().getMonthValue();
        int day = decoratedPerson.getBirth_date().getValue().getDayOfMonth();

        if (LocalDate.now().getMonthValue() == month && LocalDate.now().getDayOfMonth() == day) {
            return message + "Šiandien! Sveikiname!";
        }
        else {
            LocalDate nextBirthday = decoratedPerson.getBirth_date().getValue().withYear(LocalDate.now().getYear());
            if (nextBirthday.isBefore(LocalDate.now()) || nextBirthday.isEqual(LocalDate.now())) {
                nextBirthday = nextBirthday.plusYears(1);
            }
            long daysUntilBirthday = ChronoUnit.DAYS.between(LocalDate.now(), nextBirthday);
            message += "už " + daysUntilBirthday + " dienų.";
        }
        return message;
    }
    /**
     * @author Julius Jauga 5 gr. 1 pogr.
     * Builder class for BirthdayDecorator.
     */
    public static class Builder {
        Person person;
        PersonInterface personInterface;
        /**
         * Adding PersonInterface to Decorator.
         * @param personInterface PersonInterface object.
         * @return Builder to BirthdayDecorator class.
         */
        public BirthdayDecorator.Builder withDecorator(PersonInterface personInterface) {
            this.personInterface = personInterface;
            return this;
        };
        /**
         * Adding Person to Decorator.
         * @param person Person object.
         * @return Builder to BirthdayDecorator class.
         */
        public BirthdayDecorator.Builder withPerson(Person person) {
            this.person = person;
            return this;
        }
        /**
         * Building the object.
         * @return new BirthdayDecorator.
         */
        public BirthdayDecorator build() {
            return new BirthdayDecorator(this);
        }
    }
}
