package specific;

import generic.BasicClass;

public class ChildClass extends BasicClass {

    @Override
    protected void optionalMethod() {

        System.out.println("[ChildClass.optionalMethod] EXTRA STUFF HERE ");
        super.optionalMethod();
    }

//    @Override
//    public void recommendedMethod() {
//        System.out.println("[ChildClass.recommendedMethod] I'll do things my way ");
//        optionalMethod();
//
//    }

    private void mandatoryMethod (){

        System.out.println("[ChildClass.mandatoryMethod] My Own Important Stuff ");
    }

    public static void recommendedStatic (){

        System.out.println("[ChildClass.recommendedStatic] : Best Way to Do it ");
        optionalStatic();
//        mandatoryStatic();

    }
}
