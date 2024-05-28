package org.example.lab3.Model;

import org.example.lab3.Controller.OutputController;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * Class for representing a command for getting the data using singleton object.
 * Implements the Command interface for execute method.
 */
public class SingletonCommand implements Command {
    /**
     * Executes the command using Singleton object.
     * @param controller the output controller on which the command operates
     */
    @Override
    public void execute(OutputController controller) {
        controller.data_send_method.setText("Singleton");
        controller.first_name.setText(SingletonPerson.getInstance().getPerson().getFirst_name());
        controller.last_name.setText(SingletonPerson.getInstance().getPerson().getLast_name());
        controller.birth_date.setValue(SingletonPerson.getInstance().getPerson().getBirth_date().getValue());

        PersonInterface personDec = new SimplePerson.Builder().withPerson(SingletonPerson.getInstance().getPerson()).build();
        personDec = new AgeDecorator.Builder().withDecorator(personDec).withPerson(SingletonPerson.getInstance().getPerson()).build();
        personDec = new ZodiacDecorator.Builder().withDecorator(personDec).withPerson(SingletonPerson.getInstance().getPerson()).build();
        personDec = new ChineseZodiacDecorator.Builder().withDecorator(personDec).withPerson(SingletonPerson.getInstance().getPerson()).build();
        personDec = new BirthdayDecorator.Builder().withDecorator(personDec).withPerson(SingletonPerson.getInstance().getPerson()).build();
        personDec = new PlanetAgeDecorator.Builder().withDecorator(personDec).withPerson(SingletonPerson.getInstance().getPerson()).build();
        controller.message.setText(personDec.message());
    }
}
