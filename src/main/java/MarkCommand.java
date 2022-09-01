public class MarkCommand extends Command {
    int taskNo;

    public MarkCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            tasks.mark(taskNo);
            ui.showOutput("Nice! I've marked this task as done:");
            ui.showOutput(tasks.getTask(taskNo).toString());
        } catch (ArrayIndexOutOfBoundsException err) {
            throw new DukeException("Invalid task index to mark.");
        }
    }

    public boolean isExit() {
        return false;
    }
}
