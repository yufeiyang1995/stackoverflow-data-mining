package tests;

import org.junit.Test;
import parse.Parser;
import utils.TextOperation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class JunitTest {
    private static int num;
    private static Parser parser = new Parser();

    @Test
    public void test0(){
        String javaCode = TestCode.testCode0();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertEquals(0,parser.parse(javaCode).getProblems().length);

    }

    @Test
    public void test1(){
        String javaCode = TestCode.testCode1();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNotNull(parser.parse(TextOperation.addClass(javaCode)));
    }

    @Test
    public void test2(){
        String javaCode = TestCode.testCode2();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNull(parser.parse(TextOperation.addClass(javaCode)));
        assertNotNull(parser.parse(TextOperation.addMethdAndClass(javaCode)));
    }

    @Test
    public void test3(){
        String javaCode = TestCode.testCode3();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNull(parser.parse(TextOperation.addClass(javaCode)));
        assertNull(parser.parse(TextOperation.addMethdAndClass(javaCode)));
    }

    @Test
    public void test4(){
        String javaCode = TestCode.testCode4();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNotNull(parser.parse(TextOperation.addClass(javaCode)));
    }

    @Test
    public void test5(){
        String javaCode = TestCode.testCode5();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNotNull(parser.parse(TextOperation.addClass(javaCode)));
    }

    @Test
    public void test6(){
        String javaCode = TestCode.testCode6();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNull(parser.parse(TextOperation.addClass(javaCode)));
        assertNull(parser.parse(TextOperation.addMethdAndClass(javaCode)));
    }

    @Test
    public void test7(){
        String javaCode = TestCode.testCode7();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNull(parser.parse(TextOperation.addClass(javaCode)));
        assertNull(parser.parse(TextOperation.addMethdAndClass(javaCode)));
    }

    @Test
    public void test8(){
        String javaCode = TestCode.testCode8();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNull(parser.parse(TextOperation.addClass(javaCode)));
        assertNotNull(parser.parse(TextOperation.addMethdAndClass(javaCode)));
    }

    @Test
    public void test9(){
        String javaCode = TestCode.testCode9();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNotNull(parser.parse(TextOperation.addClass(javaCode)));
    }

    @Test
    public void test10(){
        String javaCode = TestCode.testCode10();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNull(parser.parse(TextOperation.addClass(javaCode)));
        assertNull(parser.parse(TextOperation.addMethdAndClass(javaCode)));
    }

    @Test
    public void test11(){
        String javaCode = TestCode.testCode11();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNull(parser.parse(TextOperation.addClass(javaCode)));
        assertNotNull(parser.parse(TextOperation.addMethdAndClass(javaCode)));
    }

    @Test
    public void test12(){
        String javaCode = TestCode.testCode12();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNull(parser.parse(javaCode));
        assertNotNull(parser.parse(TextOperation.addClass(javaCode)));
    }

    @Test
    public void test13(){
        String javaCode = TestCode.testCode13();
        TextOperation operation = new TextOperation();
        javaCode = operation.convertSymbol(javaCode);

        assertNotNull(parser.parse(javaCode));
    }
}
