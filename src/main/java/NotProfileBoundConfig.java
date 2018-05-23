import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class NotProfileBoundConfig {

    @Bean
    GenericOne specificToOne() {

        return () -> "genericOne";
    }

    @Bean
    GenericTwo specificToTwo() {

        return () -> "genericTwo";
    }

    @Bean
    @OneProfile
    @Profile("default")
    GenericThree specificToThree1() {

        return () -> "specificToThree default | one";
    }

    @Bean
    @TwoProfile
    GenericThree specificToThree2() {

        return () -> "specificToThree two";
    }
}
