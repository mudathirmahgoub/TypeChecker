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
    public void test1()
    {
        Main.main(new String[]{"-i", "src/test/java/test1.txt"});
    }
}