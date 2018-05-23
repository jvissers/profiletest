import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("two")
public class ProfileTwoTest extends AbstractProfileTest {

    @Override
    protected void checkProfiles() {

        assertThat("Two should be returned", excitement.sayIt(), equalTo("Two"));
        assertThat("specificToThree two", genericThree.generic(), equalTo("specificToThree two"));
    }
}
