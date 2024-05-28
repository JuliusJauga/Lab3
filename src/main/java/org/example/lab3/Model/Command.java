package org.example.lab3.Model;

import org.example.lab3.Controller.OutputController;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * Represents an action to be executed on an OutputController.
 */
public interface Command {
    /**
     * Executes the command on the specified output controller.
     *
     * @param controller the output controller on which the command operates
     */
    void execute(OutputController controller);
}
