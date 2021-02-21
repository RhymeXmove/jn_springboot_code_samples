package main;

import Config.javaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Food;

public class FoodMain2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("北方人");
        ctx.register(javaConfig.class);
        ctx.refresh();
        Food food = (Food) ctx.getBean("food");
        System.out.println(food.showName());
    }
}
