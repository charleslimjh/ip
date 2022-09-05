package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.exception.DukeException;
import duke.task.Event;

import java.time.LocalDateTime;

/**
 * Encapsulates a class to create an event.
 */
public class EventCommand extends Command {
    /** Stores the description and datetime of the event. */
    String desc;
    LocalDateTime datetime;

    /**
     * Constructor for EventCommand.
     * @param desc Description of event
     * @param datetime Datetime of event
     */
    public EventCommand(String desc, LocalDateTime datetime) {
        this.desc = desc;
        this.datetime = datetime;
    }

    /**
     * {@inheritDoc}
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Event tmp = new Event(desc, datetime);
        tasks.addEvent(tmp);
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
