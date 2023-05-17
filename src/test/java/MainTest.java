import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.catchSystemExit;


class MainTest {

    @Test
    void main1() throws Exception {
        String[] test = {"4", "1 2 3 4", "1 2 1 2", "5", "1 2 3 1 4"};
        int res = catchSystemExit(() -> {
            Main.main(test);
        });
        //int res = Main.main("4", "1 2 3 4", "1 2 1 2", "5", "1 2 3 1 4");
        Assertions.assertEquals(3, res);
    }

    @Test
    void main2() throws Exception {
        String[] test = {"3", "42 3 14", "1 3 3", "4", "3 14 14 3"};
        int res = catchSystemExit(() -> {
            Main.main(test);
        });
        // int res = Main.main("3", "42 3 14", "1 3 3", "4", "3 14 14 3");
        Assertions.assertEquals(0, res);
    }
}