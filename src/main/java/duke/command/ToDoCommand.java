package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.exception.DukeException;
import duke.task.Todo;

/**
 * Encapsulates a class to create a new To-Do.
 */
public class ToDoCommand extends Command {
    /** Description of the To-Do. */
    String desc;

    /**
     * Constructor for ToDoCommand.
     * @param desc Description of To-Do
     */
    public ToDoCommand(String desc) {
        this.desc = desc;
    }

    /**
     * {@inheritDoc}
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Todo tmp = new Todo(desc);
        tasks.addTodo(tmp);
        storage.write(tasks.toStringWritable());
        ui.showOutput("Got it. I added this task:");
        ui.showOutput("\t" + tmp);
        ui.showOutput("Now you have " + tasks.getLength() + " tasks in the list.");
    }

    /**
     * {@inheritDoc}
     */
    public boolean isExit() {
        return false;
    }
}
