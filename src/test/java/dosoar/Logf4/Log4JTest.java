package dosoar.Logf4;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class Log4JTest {
    private static final Logger logger = LoggerFactory.getLogger(Log4JTest.class);

    public static void main(String[] args) {
        // 记录debug级别的信息
        logger.debug("123This is debug message.");
        // 记录info级别的信息
//        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("456This is error message.");
    }
}
