package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWire_Test {
    public static void main(String[] args) {


        //Autowire
        /*

            1.1 autowire="byName"
                若實體變數的setter 方法名稱 setComputer (去掉set,C改小寫後) 跟 bean id 一樣，Spring會自動找尋相同名字的bean

                <bean id="alien3" class="org.example.Alien" autowire="byName">
                    <property name="age" value="31"></property>

                </bean>

                <bean id="computer" class="org.example.Laptop" ></bean>

            1.2 若有宣告autowire且同時在bean檔有設定property所參照的物件，會以property為主

                <bean id="alien3" class="org.example.Alien" autowire="byName">
                    <property name="age" value="31"></property>
                    <property name="computer" ref="desktop"></property>
                </bean>

                // 會找bean id ="desktop" 來創建實體變數


            2. autowire="byType"
               宣告byType則會尋找是否有符合的bean，若有重複則會報錯

                <bean id="alien3" class="org.example.Alien" autowire="byType">
                    <property name="age" value="31"></property>
                </bean>

                <bean id="computer1" class="org.example.Laptop" ></bean>
                <bean id="computer2" class="org.example.Desktop" ></bean>

                public class Alien {
                private int age;
                private Computer computer;}

                //結果會報錯，因為型態宣告為Computer，Spring會不知道要用哪一個bean


            2.2 primary bean
               宣告byType則會尋找是否有符合的bean，即便有重複若有宣告primary則會優先使用

                <bean id="alien3" class="org.example.Alien" autowire="byType">
                    <property name="age" value="31"></property>
                </bean>

                <bean id="computer1" class="org.example.Laptop primary="true" ></bean>
                <bean id="computer2" class="org.example.Desktop" ></bean>

                //結果會用Laptop物件作為實體變數

            3.1

        */

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Alien alien3 = (Alien) context.getBean("alien3");
        alien3.code();


        //Lazy init
        /*
                bean 若宣告 lazy-init="ture" 則會再被宣告時才創建物件 (scope:singleton)
                <bean id="computer2" class="org.example.Desktop" lasy-init="ture"></bean>
        */

//        Laptop laptop3 = (Laptop) context.getBean("computer1");


        //Get bean by type
        /*
               1. context.getBean("id") 需要轉型
        */

//        Laptop laptop4 = (Laptop) context.getBean("computer1");


        /*
               2. context.getBean("id", Type.class) 不需要轉型
        */

//        Laptop laptop5 = context.getBean("computer1", Laptop.class);

        /*
               3. context.getBean(Type.class) 直接填入要使用的型別

               如果此Type有宣告多個bean且沒有primary則會報錯
               若有bean宣告為primary則會優先採用primary的bean

               <bean id="laptop1" class="org.example.Laptop" scope="prototype"></bean>
               <bean id="computer1" class="org.example.Laptop" lazy-init="true" primary="true"></bean>

        */

//        Laptop laptop6 = context.getBean(Laptop.class);


        /*
               4. context.getBean(InterfaceType.class) 使用介面多型

               共有三個bean可用Computer來多型宣告
               報錯：expected single matching bean but found 3: laptop1,computer1,computer

               如果有宣告primary則會採用primary的bean


               <bean id="laptop1" class="org.example.Laptop" scope="prototype"></bean>
               <bean id="computer1" class="org.example.Laptop" lazy-init="true" primary="true"></bean>
               <bean id="computer" class="org.example.Desktop" ></bean>
        */

        Computer computer = context.getBean(Computer.class);
        computer.compile();


        //Inner bean
        //Inner bean的物件只能由outer bean來使用
        /*
            <bean id="alien" class="org.example.Alien" >
                <property name="age" value="31"></property>
                <bean id="laptop1" class="org.example.Laptop" scope="prototype"></bean>

            </bean>

         */
    }
}
