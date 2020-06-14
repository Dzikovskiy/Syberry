package dzikovskiy;

import java.util.List;

/**
 * A scheduler interface is intended to process a random list of tasks with the information of their predecessors
 * and return a list of the same tasks but in order they may be executed according to their dependencies
 */

interface IScheduler {
    public List<Task> schedule(List<Task> tasks);
}
