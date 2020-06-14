package dzikovskiy;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /**
         * The following is the example of how the scheduler may be used
         */
        List<Task> tasks = Arrays.asList(
                new Task("E", Arrays.asList("B")),
                new Task("D", Arrays.asList("A", "B")),
                new Task("A", Arrays.asList("O")),
                new Task("B", Arrays.asList("A")),
                new Task("C", Arrays.asList("D", "B")),
                new Task("F", Arrays.asList("E")),
                /**
                 *  "Z" don't have parent task. And there are two situations:
                 *  1) We create such parent task
                 *  2) We don't create parent task, but in that case we won't be able to iterate through that task bellow
                 */
                new Task("O", Arrays.asList("Z")),
                new Task("X", Arrays.asList("O")),
                new Task("G", Arrays.asList("F"))
        );

        IScheduler scheduler = new BaseScheduler();
        List<Task> sortedTasks = scheduler.schedule(tasks);
        for (Task t : sortedTasks) {
            System.out.println(t.getName());
        }
    }
}