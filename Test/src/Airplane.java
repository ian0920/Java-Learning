public class Airplane implements Flyable {

    private String type;
    private String module;

    public Airplane (){

    }

    public Airplane (String type, String module){
        this.type = type;
        this.module = module;
    }

    public void info (){
        System.out.println("Airplane is waiting to take off");
    }


    public void fly() {
        System.out.println("Airplane fly with engines");
    }
}
