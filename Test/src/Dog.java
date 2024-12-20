public class Dog extends Animal implements Barkable{

    private String name;
    private String size;
    private String type;


    public Dog(){

    }

    public Dog (int age, float weight, String name, String size, String type){
        super(age, weight);
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public void wavingTail (){
        System.out.println("Dogs wave tail when they are happy.");
    }

    @Override
    public void bark (){
        System.out.println("Dog bark\"woof!\"");
    }

    @Override
    public void speak(){
        super.speak();
        System.out.println("haha");
    }

}
