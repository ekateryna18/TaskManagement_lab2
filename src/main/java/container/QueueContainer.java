package container;

import model.Task;

import static utils.Constants.INITIAL_CONTAINER_SIZE;

public class QueueContainer extends ContainerSuperclass {
    public QueueContainer() {
        super();
        tasks = new Task[INITIAL_CONTAINER_SIZE];
    }

    @Override
    public Task remove() {
        if(!isEmpty()) {
            Task[] t=new Task[tasks.length];
            Task deleted_t = this.tasks[0];
            size--;
            System.arraycopy(tasks, 1, t, 0, size);
            tasks=t;
            return deleted_t;
        }
        return null;
    }
}
