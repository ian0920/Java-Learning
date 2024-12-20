public class Animal {

    private int age;
    private float weight;

    public Animal(){

    }


    public Animal (int age, float weight){
        this.age = age;
        this.weight = weight;
    }


    void speak(){
        System.out.println("age = " + age);
        System.out.println("weight = " + weight);
    }


}
