package org.example.config;

import org.example.Alien;
import org.example.Computer;
import org.example.Desktop;
import org.example.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // Annotation for Java Based Configuration
@ComponentScan("org.example") //告訴Spring到哪個package去找這些Bean
public class AppConfig {

    @Bean(name = {"desk1", "desktop", "d1"})
//    @Scope("prototype")
    public Desktop desktop(){
        return new Desktop();
    }

    @Bean
    @Primary
    public Laptop laptop(){
        return new Laptop();
    }


    @Bean
    public Alien alien(@Qualifier("desktop") Computer com){  // 建議寫法，運用多形 @Autowired可省略
        Alien obj = new Alien();
        obj.setAge(31);
        obj.setComputer(com);
        return obj;
    }

    /*
    @Bean
    public Alien alien(){
        Alien obj = new Alien();
        obj.setAge(31);
        obj.setComputer(desktop());  // 不推薦寫法，造成Alien跟desktop的耦合性增加
        return obj;
    }

    */


}
