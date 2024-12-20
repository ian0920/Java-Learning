public class Cat extends Animal implements Barkable{

    private String name;
    private String color;
    private String type;


    public Cat(){

    }

    public Cat (int age, float weight, String name, String color, String type){
        super(age, weight);
        this.name = name;
        this.color = color;
        this.type = type;
    }

    public void knockOverEveryThing (){
        System.out.println("Cat like to knock over everything on the table");
    }

    @Override
    public void bark() {
        System.out.println("Dog bark\"Meows!\"");
    }
}
