import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest
{
    @Test
    public void noArguments()
    {
        Main.main(new String[]{});
    }

    @Test
    public void test()
    {
        Main.main(new String[]{"-i", "src/main/test/java/test.txt"});
    }
}