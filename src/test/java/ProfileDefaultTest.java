import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

// No profile is activated - this means system should pick up "default" ~ which is Spring's default profile
public class ProfileDefaultTest extends AbstractProfileTest {

    @Override
    protected void checkProfiles() {

        assertThat("One should be returned", excitement.sayIt(), equalTo("One"));
        assertThat("specificToThree default | one returned", genericThree.generic(), equalTo("specificToThree default | one"));
    }
}
