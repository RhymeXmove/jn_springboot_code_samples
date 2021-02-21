package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import service.Food;
import service.Noodles;
import service.Rice;
import service.impl.NoodlesConditon;
import service.impl.RiceCondition;

@Configuration
public class javaConfig {
    @Bean("food")
    @Profile("南方人")
    Food rice() {
        return new Rice();
    }

    @Bean("food")
    @Profile("北方人")
    Food noodles() {
        return new Noodles();
    }
}
