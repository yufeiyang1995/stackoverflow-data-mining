import com.google.common.reflect.ClassPath;
import org.xml.sax.InputSource;
import parse.Parser;

import tests.TestCode;
import utils.FindApi;
import utils.TextOperation;

import java.io.IOException;
import java.security.KeyStore;

public class Main {
    public static void main(String[] args) throws IOException {
        FindApi.classPath = ClassPath.from(ClassLoader.getSystemClassLoader());
        /* run single code */
        // runSingleCode();
        /*
        * run code file
        * real filepath: String filePath = "/Volumes/Young/Py-StackExchange/security/code.xml";
        * test filepath: String filePath = "/Users/yangyufei/Desktop/code-100.xml";
        * */
        String filePath = "/Volumes/Young/Py-StackExchange/security/code.xml";
        runXmlCodes(filePath);

    }

    private static void runSingleCode(){
        String javaCode = TestCode.testCode17();
        TextOperation operation = new TextOperation();

        javaCode = operation.convertSymbol(javaCode);
        System.out.println(javaCode);
        Parser parser = new Parser();

        if(parser.parse(javaCode) != null){
            System.out.println("Origin is JavaCode...");

        } else if(parser.parse(TextOperation.addClass(javaCode)) != null){
            System.out.println("Add Class is JavaCode...");

        } else if(parser.parse(TextOperation.addMethdAndClass(javaCode)) != null){
            System.out.println("Add Class&Method is JavaCode...");
        } else {
            System.out.println("Not a JavaCode...");
        }
    }

    public static void runXmlCodes(String filePath){
        TextOperation operation = new TextOperation();
        // operation.analysisCodeFromXml(filePath);
        operation.analysisPostFromXml(filePath);
    }

}
