package generic;

public class BasicClass {


    public final void recommendedMethod(){

        System.out.println("[BasicClass.recommendedMethod] : Best Way to Do it ");
        optionalMethod();
        mandatoryMethod();

    }

    protected void optionalMethod() {

        System.out.println("[BasicClass.optionalMethod] : Customized optional Method ");
    }

    private void mandatoryMethod() {

        System.out.println("[BasicClass.mandatoryMethod] : NON-NEGOTIABLE! ");

    }

    public static void recommendedStatic (){

        System.out.println("[BasicClass.recommendedStatic] : Best Way to Do it ");
        optionalStatic();
        mandatoryStatic();

    }

    protected static void optionalStatic(){

        System.out.println("[BasicClass.optionalStatic] : Optional ");

    }


    private static void mandatoryStatic(){

        System.out.println("[BasicClass.mandatoryStatic] : MANDATORY ");

    }

}
