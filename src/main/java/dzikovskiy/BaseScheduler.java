package dzikovskiy;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.TopologicalOrderIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseScheduler implements IScheduler {

    @Override
    public List<Task> schedule(List<Task> tasks) {
        List<Task> list = new ArrayList<>();
        Graph<String, DefaultEdge> graph = new SimpleDirectedGraph<>(DefaultEdge.class);

        for (Task task : tasks) {// creates directed graph from tasks list
            graph.addVertex(task.getName());
            if (!task.getPredecessors().isEmpty()) {
                for (String predecessor : task.getPredecessors()) {
                    if (!predecessor.equals("")) {
                        graph.addVertex(predecessor);
                        graph.addEdge(predecessor, task.getName());
                    }
                }
            }
        }

        //test for directed path if interesting:
//        System.out.println("Shortest path from Z to G:");
//        DijkstraShortestPath<String, DefaultEdge> dijkstraAlg =
//                new DijkstraShortestPath<>(graph);
//        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultEdge> iPaths = dijkstraAlg.getPaths("Z");
//        System.out.println(iPaths.getPath("G") + "\n");

        TopologicalOrderIterator<String, DefaultEdge> iterator = new TopologicalOrderIterator<>(graph);
        while (iterator.hasNext()) {
            String vertex=iterator.next();
            list.add(new Task(vertex,Arrays.asList("")));
        }
        return list;
    }
}