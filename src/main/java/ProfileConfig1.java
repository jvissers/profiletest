import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@OneProfile
@Configuration
@Profile("default")
public class ProfileConfig1 {

    @Bean
    Excitement excitement() {

        return () -> "One";
    }
}
