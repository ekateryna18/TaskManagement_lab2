package container;

import model.Task;

import static utils.Constants.INITIAL_CONTAINER_SIZE;

public class StackContainer extends ContainerSuperclass {

    public StackContainer() {
        super();
        tasks = new Task[INITIAL_CONTAINER_SIZE];
    }
    @Override
    public Task remove() {
        if (!isEmpty()) {
            size--;
            return tasks[size];
        }
        return null;
    }
}
