public abstract class Bird implements Flyable{

    private String name;
    private String color;
    private String type;

    public Bird (){

    }

    public Bird (String name, String color, String type){

        this.name = name;
        this.color = color;
        this.type = type;
    }

    public void chirp (){
        System.out.println("bird is chirping.");
    }


}
