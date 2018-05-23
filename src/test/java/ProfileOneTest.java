import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("one")
public class ProfileOneTest extends AbstractProfileTest {

    @Override
    protected void checkProfiles() {

        assertThat("One should be returned", excitement.sayIt(), equalTo("One"));
        assertThat("specificToThree default | one returned", genericThree.generic(), equalTo("specificToThree default | one"));
    }
}
