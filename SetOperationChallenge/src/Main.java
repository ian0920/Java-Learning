import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTask("ALL");
        sortAndPrint("All tasks :", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);

        Set<Task> annsTasks = TaskData.getTask("Ann");
        Set<Task> bobsTasks = TaskData.getTask("Bob");
        Set<Task> carolsTasks = TaskData.getTask("Carol");

        Set<Task> allPlusAnn = getUnion(tasks,annsTasks);
        Set<Task> allPlusAnnPlusBob = getUnion(allPlusAnn,bobsTasks);
        Set<Task> allTask = getUnion(allPlusAnnPlusBob, carolsTasks);
        sortAndPrint("True all tasks", allTask); // all ∪ ann  ∪ bob  ∪ carol


        Set<Task> annPlusBob = getUnion(annsTasks,bobsTasks);
        Set<Task> annPlusBobPlusCarol = getUnion(annPlusBob,carolsTasks);
        sortAndPrint("assigned to at least one of your 3 team members", annPlusBobPlusCarol);


        Set<Task> missingTask = getDifference(allTask,tasks);
        sortAndPrint("Missing Task ", missingTask, sortByPriority);


        Set<Task> allMinusAnn = getDifference(allTask, annsTasks);
        Set<Task> allMinusAnnMinusBob = getDifference(allMinusAnn, bobsTasks);
        Set<Task> allMinusAnnMinusBobMinusCarol = getDifference(allMinusAnnMinusBob, carolsTasks);
        sortAndPrint("tasks still need to be assigned", allMinusAnnMinusBobMinusCarol,sortByPriority);



        Set<Task> annAndBob = getIntersect(annsTasks,bobsTasks);
        Set<Task> annAndCarol = getIntersect(annsTasks,carolsTasks);
        Set<Task> BobAndCarol = getIntersect(bobsTasks, carolsTasks);

        Set<Task> a = getUnion(annAndBob,annAndCarol);
        Set<Task> intersectOfThreeWorker = getUnion(a,BobAndCarol);

        sortAndPrint("assigned to multiple employees", intersectOfThreeWorker,sortByPriority);








    }

    public static void sortAndPrint (String header, Collection<Task> collection){
        sortAndPrint(header, collection, null);

        //In Java, if you have a class that implements the Comparable interface
        // and you call list.sort(null) on a list of objects of that class,
        // the sorting will be done using the natural order defined by the compareTo method of the Comparable interface.

    }

    public static void sortAndPrint (String header, Collection<Task> collection, Comparator<Task> sorter){

        String lineSeparator = "-".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);

    }

    public static Set<Task> getUnion (Set<Task> tasksA, Set<Task> tasksB){

        Set<Task> union = new HashSet<>(tasksA);
        union.addAll(tasksB);

        return union;
    }

    public static Set<Task> getIntersect (Set<Task> tasksA, Set<Task> tasksB){

        Set<Task> intersect = new HashSet<>(tasksA);
        intersect.retainAll(tasksB);

        return intersect;

    }

    public static Set<Task> getDifference (Set<Task> tasksA, Set<Task> tasksB){

        Set<Task> difference = new HashSet<>(tasksA);
        difference.removeAll(tasksB);

        return difference;

    }

}
