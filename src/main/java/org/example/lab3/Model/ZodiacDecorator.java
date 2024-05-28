package org.example.lab3.Model;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * A class designed to decorate a person object with aditional information about the Person.
 * This class extends the PersonDecorator class to add functionality to message method. This decorator adds Zodiac sign information.
 */
public class ZodiacDecorator extends PersonDecorator {
    private final Person decoratedPerson;
    /**
     * Private constructor for ZodiacDecorator
     * @param builder Builder
     */
    private ZodiacDecorator(Builder builder) {
        super(builder.personInterface);
        this.decoratedPerson = builder.person;
    }
    /**
     * Method to calculate the Zodiac in lithuanian.
     * @return String Zodiac in lithuanian
     */
    public String getZodiac() {
        int month = decoratedPerson.getBirth_date().getValue().getMonthValue();
        int day = decoratedPerson.getBirth_date().getValue().getDayOfMonth();
        return switch (month) {
            case 1 -> (day <= 20) ? "Ožiaragis" : "Vandenis";
            case 2 -> (day <= 19) ? "Vandenis" : "Žuvys";
            case 3 -> (day <= 20) ? "Žuvys" : "Avinas";
            case 4 -> (day <= 20) ? "Avinas" : "Jautis";
            case 5 -> (day <= 21) ? "Jautis" : "Dvyniai";
            case 6 -> (day <= 21) ? "Dvyniai" : "Vėžys";
            case 7 -> (day <= 22) ? "Vėžys" : "Liūtas";
            case 8 -> (day <= 23) ? "Liūtas" : "Mergelė";
            case 9 -> (day <= 23) ? "Mergelė" : "Svarstyklės";
            case 10 -> (day <= 23) ? "Svarstyklės" : "Skorpionas";
            case 11 -> (day <= 22) ? "Skorpionas" : "Šaulys";
            case 12 -> (day <= 22) ? "Šaulys" : "Ožiaragis";
            default -> "Nežinomas";
        };
    }
    /**
     * Adds additional content to the message.
     * @return the message from the decorated person concatenated with new information.
     */
    @Override
    public String message() {
        return super.message() + "Jūsų Zodiako ženklas yra " + getZodiac() + ". ";
    }
    /**
     * @author Julius Jauga 5 gr. 1 pogr.
     * Builder class for ZodiacDecorator.
     */
    public static class Builder {
        Person person;
        PersonInterface personInterface;
        /**
         * Adding PersonInterface to Decorator.
         * @param personInterface PersonInterface object.
         * @return Builder to ZodiacDecorator class.
         */
        public ZodiacDecorator.Builder withDecorator(PersonInterface personInterface) {
            this.personInterface = personInterface;
            return this;
        };
        /**
         * Adding Person to Decorator.
         * @param person Person object.
         * @return Builder to ZodiacDecorator class.
         */
        public ZodiacDecorator.Builder withPerson(Person person) {
            this.person = person;
            return this;
        }
        /**
         * Building the object.
         * @return new ZodiacDecorator.
         */
        public ZodiacDecorator build() {
            return new ZodiacDecorator(this);
        }
    }
}
