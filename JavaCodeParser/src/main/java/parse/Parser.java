package parse;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.*;
import utils.Printer;

import java.util.*;


/*
 * parse Java code & Generate AST For Analysis
 */
public class Parser {
    private HashMap<String, Integer> classCountMap = new HashMap<>();
    private HashMap<String, Integer> otherClassCountMap = new HashMap<>();

    public CompilationUnit parse(String javaCode){
        ASTParser parser = ASTParser.newParser(AST.JLS8);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        // Set Java Version & Compile Option
        Map<String, String> compilerOptions = JavaCore.getOptions();
        compilerOptions.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_8);
        compilerOptions.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_8);
        compilerOptions.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_8);
        parser.setCompilerOptions(compilerOptions);

        parser.setSource(javaCode.toCharArray());
        CompilationUnit node = (CompilationUnit) parser.createAST(null);
        System.out.println(node);
        //System.out.println("node:" + node.types().size());
        if(node.getProblems().length > 0) {
            return null;
        }

        /*
         * 获取分析节点信息
         *
         * // 暂时不需要
         *
        List types = node.types();
        TypeDeclaration typeDec = (TypeDeclaration) types.get(0);
        System.out.println("TypeDec: " + typeDec.getName().toString());
        for(Object prop : node.structuralPropertiesForType()){
            if(prop instanceof ChildListPropertyDescriptor){
                String id = ((ChildListPropertyDescriptor) prop).getId();
                System.out.println("childList: "+ id);
            } else if(prop instanceof ChildPropertyDescriptor){
                String id = ((ChildPropertyDescriptor) prop).getId();
                System.out.println("child: "+ id);
            } else {
                String id = ((SimplePropertyDescriptor)prop).getId();
                System.out.println("simple: "+ id);
            }
        }*/

        // Visiter遍历节点
        MyVisitor myVisitor  = new MyVisitor();
        if(node.imports().size() > 0){
            myVisitor.setImports(node.imports());
        }
        node.accept(myVisitor);
        Printer.println("Classes: "+myVisitor.getClasses());
        countMap(myVisitor.getClasses(), classCountMap);
        countMap(myVisitor.getOtherClass(), otherClassCountMap);
        return node;
    }

    /*
     * 统计多个set元素数量到map
     */
    private void countMap(HashSet<String> set, HashMap<String, Integer> map){
        for(String s : set){
            if(map.containsKey(s)){
                int old = map.get(s);
                map.put(s, old+1);
            } else {
                map.put(s, 1);
            }
        }
    }

    /*
     * Print parse Problems
     */
    public void printProblems(CompilationUnit node){
        int index = 0;
        for(IProblem p : node.getProblems()){
            System.out.println("P"+index + ": "+p.toString());
            index++;
        }
    }

    /*
       Getter & Setter
     */
    public HashMap<String, Integer> getClassCountMap() {
        return classCountMap;
    }

    public HashMap<String, Integer> getOtherClassCountMap() {
        return otherClassCountMap;
    }
}
