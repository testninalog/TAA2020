package test.java;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import com.taa2020.day12.BasicCalculator;
import com.taa2020.day12.Calculator;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("regression")
@ExtendWith(ReporterTestException.class)//output ce biti drugaciji, izvrsavac se bas pre testa
public class MyTest {//imamo mogucnost da uradimo extendovanje standadno extends ime klase ili pomocu taga @ExtendWith(ime.class)

    private static final Logger logger = LogManager.getLogger(MyTest.class);//logujemo rezultate

    private static int a;

    private static int b;

    private static int c;

    @BeforeAll
    public static void beforeAllTests() {
        logger.info("Starting my tests suite");
        a = 2;
        b = 3;
        c = 4;
    }

    @AfterAll
    public static void afterAllTests() {
        logger.info("Ending my tests suite");
    }

    @BeforeEach
    public void beforeTest() {
        logger.info(" @BeforeEach - Starting a test");

    }

    @AfterEach
    public void afterTest() {
        logger.info("@AfterEach - Ending a test");
    }



    @Test
    @Order(1)
   // @Order(1)//ako hocemo neki redosled
    public void testMultiply() {
        // GIVEN
        Calculator calculator = new Calculator();

        // WHEN
        int m = calculator.multiply(a, b, c);

        // THEN
        logger.info(m);
    }


    @Test
    @Order(2)
    public void testSum() {
        // GIVEN
        Calculator calculator = new Calculator();

        // WHEN
        int sum = calculator.add2(++a, b++);

        // THEN
        logger.info(sum);

    }

    @Tag("sanity")
    @Tag("regression")


    @Test
    @Order(3)
    public void testDivide() {
        // GIVEN
        BasicCalculator bc = new BasicCalculator();

        // WHEN
        double d = bc.divide( 20, 6 );

        // THEN
       // assertEquals(5L, d);

        assertThat( d, closeTo(3.3, 0.034) );
    }




}
