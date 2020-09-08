package test.java;

import com.taa2020.day12.BasicCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

public class NoviTest {
    //    public static void main(String[] args) {
//        System.out.println("Hello");
//    }
    private static final Logger logger = LogManager.getLogger( NoviTest.class );
    @BeforeAll
    public static void beforeAllTest() {

        logger.info("Izvrsava se beforeAllTest");
    }

    @AfterAll
    public static void afterAllTest() {

        logger.info("Zatvori browser");
    }

    @BeforeEach
    public void beforaEachTest() {

        logger.info("Startuj kalkulator");
    }

    @AfterEach
    public void afterEachTest() {

        logger.info("Zatvori kalkulator");
    }


    @Test
    public void prviTest() {

        logger.info("Hello");
    }

    @Test
    public void drugiTest() {
        //GIVEN  - preduslov
        BasicCalculator calculator = new BasicCalculator();

        //WHEN   -sta radimo
        int rezultat = calculator.add(10, 2, 6);

        //THEN   -sta proveravamo
        logger.info(rezultat);

    }

}

