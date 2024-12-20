package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectCreating_Test
{
    public static void main( String[] args )
    {
        // 告訴編譯器Bean的設定檔在哪裡
        //Scope singleton          並同時創建物件
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");


        // alien1 and alien2 為同一個物件，原則上一個Class只會產生一個物件 (scope: singleton by default)
        Alien alien1 = (Alien) context.getBean("alien");
        alien1.code();

        Alien alien2 = (Alien) context.getBean("alien");
        alien2.code();


        // Scope: prototype。 每次getBean()創建物件時為不同物件
        Laptop laptop1 = (Laptop) context.getBean("laptop1"); //getBean()時才創建物件
        laptop1.number = 1;
        System.out.println(laptop1.number);

        Laptop laptop2 = (Laptop) context.getBean("laptop1");
        laptop2.number = 2;
        System.out.println(laptop2.number);


        System.out.println("====Setter Injection===");
        // Setter Injection (實體變數inject)
        /*
            1. Class 中需創建 setter & getter 方法
            2. 在 application.xml 設定 Bean
            3. <property name="實體變數名稱(primitive type)" value="值"></property>
               若實體變數為基本資料型態，則設定變數的值時用 "value"來設定
            4. <property name="實體變數名稱(object type)" ref="BeanId"></property>
               若實體變數為物件型態，不需要自己new 一個物件，在ref指定想要創建的物件的BeanId (laotop1)
            5.  Spring 在背景創建物件的同時，利用setter方法將實體變數設定好了
        */


        System.out.println("Spring透過setter injection 將 alien1的實體變數依照設定檔的參數設定完成");
        System.out.println("alien1 age: " + alien1.getAge());
        System.out.println("alien1 lap: " + alien1.getComputer());

        System.out.println("====Constructor Injection===");

        // Constructor Injection (實體變數inject)
        /*
            1. Class 中需創建 arg-constructor
            2. 在 application.xml 設定 Bean
            3. <constructor-arg value="值"/>
               若實體變數為基本資料型態，則設定變數的值時用 "value"來設定
            4. <constructor-arg ref="BeanId"/>
               若實體變數為物件型態，不需要自己new 一個物件，在ref指定想要創建的物件的BeanId (laotop1)
            5. Spring 在背景創建物件的同時，利用Constructor將實體變數設定好了

            6. 若有多個實體變數
                    6.1 依照宣告的順序來排列
                        <constructor-arg value="21"/>
                        <constructor-arg ref="laptop1"/>
                    6.2 宣告時標註參數的型態
                        <constructor-arg type="org.example.Laptop" ref="laptop1"/>
                        <constructor-arg type="int" value="21"/>
              (常用) 6.3 宣告時標註參數的索引值
                        <constructor-arg index="0" value="21"/>
                        <constructor-arg index="1" ref="laptop1"/>
                    6.4 宣告時標註實體變數的名稱(需注意順序或在Constructor加上@ConstructorProperties({"age", "laptop"}))
                        <constructor-arg name="age" ref="laptop1"/>
                        <constructor-arg name="laptop" value="21"/>
        */


        System.out.println("Spring透過Constructor Injection 將 alien2_1的實體變數依照設定檔的參數設定完成");
        Alien2 alien2_1 = (Alien2) context.getBean("alien2");
        System.out.println("alien2_1 age: " + alien2_1.age);
        System.out.println("alien2_1 lap: " + alien2_1.computer);




    }
}
