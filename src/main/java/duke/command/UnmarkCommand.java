package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.exception.DukeException;

public class UnmarkCommand extends Command {
    int taskNo;

    public UnmarkCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            tasks.unmark(taskNo);
            storage.write(tasks.toStringWritable());
            ui.showOutput("Ok, I've marked this task as not done yet:");
            ui.showOutput("\t" + tasks.getTask(taskNo).toString());
        } catch (IndexOutOfBoundsException err) {
            throw new DukeException("Invalid task index to unmark.");
        }
    }

    public boolean isExit() {
        return false;
    }
}
