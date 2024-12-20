import external.util.Logger;
import generic.BasicClass;
import specific.ChildClass;

public class Main {

    public static void main(String[] args) {

        BasicClass parent = new BasicClass();
        BasicClass childReferredToAsBase = new ChildClass();
        ChildClass child = new ChildClass();

        parent.recommendedMethod();
        System.out.println("--------------------");
        childReferredToAsBase.recommendedMethod();
        System.out.println("--------------------");
        child.recommendedMethod();

        System.out.println("--------------------");
        parent.recommendedStatic();
        System.out.println("--------------------");
        childReferredToAsBase.recommendedStatic();
        System.out.println("--------------------");
        child.recommendedStatic();


        String xArgument = "This is all I've got to say about Section ";
        StringBuilder zArgument = new StringBuilder("Only saying this : Section ");
        doXYZ(xArgument, 16, zArgument);
        System.out.println("After method, xArgument = " + xArgument);
        System.out.println("After method, zArgument = " + zArgument);
        doXYZ(xArgument, 13, zArgument);


        StringBuilder tracker = new StringBuilder("Step 1 is abc ");
        Logger.logToConsole(tracker.toString());
        tracker.append(" , Step 2 is xyz");
        Logger.logToConsole(tracker.toString());
        System.out.println("After Logging, tracker = " + tracker);

    }


    private static void doXYZ (String x, int y, StringBuilder z){

        final String c = x+y;
        System.out.println("C = " + c);
        x = c;
        z.append(y);

    }

}
