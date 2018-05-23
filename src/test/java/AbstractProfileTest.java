import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

@ContextConfiguration(classes = { ProfileConfig1.class, ProfileConfig2.class, NotProfileBoundConfig.class })
public abstract class AbstractProfileTest {

    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    protected Excitement excitement;
    @Autowired
    protected GenericThree genericThree;
    @Autowired
    private GenericOne genericOne;
    @Autowired
    private GenericTwo genericTwo;

    @Test
    public void testProfiles() {

        assertThat("GenericOne is there", genericOne.generic(), equalTo("genericOne"));
        assertThat("GenericTwo is there", genericTwo.generic(), equalTo("genericTwo"));
        checkProfiles();
    }

    /**
     * Checks profile behavior in separate contexts:
     * - ProfileDefaultTest : no profile is activated, which means that "default" profile should prevail (i.e. Profile1Config)
     * - ProfileOneTest : "one" profile is activated, we want 'Excitement' bean coming from Profile1Config
     * - ProfileTwoTest : "one" profile is activated, we want 'Excitement' bean coming from Profile2Config
     * Regardless of this behavior we want the beans coming from a configuration which is not profile bound
     * i.e. NotProfileBoundConfig to be present and ready for us.
     */
    protected abstract void checkProfiles();
}
