import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@TwoProfile
@Configuration
public class ProfileConfig2 {

    @Bean
    Excitement excitement() {

        return () -> "Two";
    }
}
