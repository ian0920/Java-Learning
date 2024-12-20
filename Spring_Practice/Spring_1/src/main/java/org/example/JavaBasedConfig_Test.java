package org.example;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaBasedConfig_Test {

    public static void main(String[] args) {

        //使用Java檔而非XML檔作為設置 Java Based Configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //用物件型別來要求Spring 提供物件
        Desktop d1 = context.getBean(Desktop.class);
        d1.compile();

        //用Bean name來要求Spring提供物件，預設的name就是方法的名稱
        Desktop d2 = context.getBean("desktop", Desktop.class);
        d2.compile();

        //用自行設定的Bean name來要求Spring提供物件
        //若有多個name可宣告成陣列：@Bean(name = {"desk1", "desktop", "d1"})
        Desktop d3 = context.getBean("desk1", Desktop.class);
        d3.compile();


        //@Scope("singleton")為預設，@Scope("prototype")可創建多個物件

        //在Bean設置成員變數
        Alien alien = context.getBean(Alien.class);
        System.out.println(alien.getAge()); // 在Bean設置原始型態的成員變數
        alien.code(); //dependent on Computer，在Bean設置自訂型別的成員變數


        //Autowired @Qualifier("指定的bean")
        // 若因多型造成多個Bean皆有可能被Autowired，可以使用@Qualifier指定特定想使用的Bean
        // 意同<property name="computer" ref="laptop1"></property> 在ref指定特定的Bean

        alien.code(); // @Qualifier("laptop") 使用laptop

        //Autowired @Primary
        //若因多型造成多個Bean皆有可能被Autowired，亦可使用@Primary告訴Spring優先使用哪個Bean
        //@Qualifier("指定的bean") > @Primary 若有使用Qualifier擇優先於@Primary


        Pad pad = context.getBean(Pad.class);
        pad.compile();









    }



}
