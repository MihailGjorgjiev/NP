package CollectionBook.DesignPatterns.TaskManager;

public abstract class TaskDecorator implements ITask{
    private ITask iTask;

    public TaskDecorator(ITask iTask) {
        this.iTask = iTask;
    }

    public ITask getiTask() {
        return iTask;
    }
}
