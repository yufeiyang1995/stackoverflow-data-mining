package parse;

import org.eclipse.jdt.core.dom.*;
import utils.FindApi;
import utils.Printer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Visit ASTNode & Find Security-related APIs
 */
public class MyVisitor extends ASTVisitor{
    private HashSet<String> classes = new HashSet<>();
    private ArrayList<String> methods = new ArrayList<>();
    private ArrayList<String> imports = new ArrayList<>();
    private ArrayList<String> starImport = new ArrayList<>();
    private HashSet<String> otherClass = new HashSet<>();
    private FindApi find = new FindApi();

    @Override
    public boolean visit(Assignment node) {
        return super.visit(node);
    }

    // 成员变量声明
    @Override
    public boolean visit(FieldDeclaration node) {
        System.out.println("FieldDeclaration: "+node.toString());
        addClasses(node.getType().toString());
        return super.visit(node);
    }

    // 变量初始化语句
    @Override
    public boolean visit(VariableDeclarationStatement node) {
        Printer.println("VariableDeclarationStatement: "+node.toString());

        addClasses(node.getType().toString());
        return super.visit(node);
    }

    // 变量初始化表达式
    @Override
    public boolean visit(VariableDeclarationExpression node) {
        Printer.println("VariableDeclarationExpression: " + node.toString());
        addClasses(node.getType().toString());
        return super.visit(node);
    }

    // 数组变量
    @Override
    public boolean visit(ArrayType node) {
        Printer.println("ArrayType: "+node.toString());
        addClasses(node.getElementType().toString());
        return super.visit(node);
    }

    // 参数变量
    @Override
    public boolean visit(ParameterizedType node) {
        System.out.println("ParameterizedType: "+node.getType());
        for(Object o : node.typeArguments()){
            addClasses(o.toString());
        }

        return super.visit(node);
    }

    // 对象实例化
    @Override
    public boolean visit(ClassInstanceCreation node) {
        Printer.println("ClassInstanceCreation: "+node.getType());
        addClasses(node.getType().toString());

        return super.visit(node);
    }

    /*
     * For Test & Debug
    @Override
    public void postVisit(ASTNode node) {
        System.out.println("nodetype: "+node.getNodeType());
        super.postVisit(node);
    }
    */

    // 变量声明
    @Override
    public boolean visit(SingleVariableDeclaration node) {
        System.out.println("single: "+node.toString());
        addClasses(node.getType().toString());
        return super.visit(node);
    }

    // 方法调用
    @Override
    public boolean visit(MethodInvocation node) {
        // System.out.println("MethodInvocation: "+node);
        return super.visit(node);
    }

    public void addClasses(String className){
        if(className.contains("."))
            className = className.substring(className.lastIndexOf(".")+1, className.length());
        try {
            if(imports.size() == 0) {
                ArrayList<String> result = find.GetPackageName(className);
                if(result.size() == 0)
                    addOtherClass(className);
                else
                    classes.addAll(result);
            } else {
                for(String s : imports){
                    if(s.startsWith("java") || s.startsWith("javax")){
                        if(s.substring(s.lastIndexOf(".")+1, s.length()).equals(className)){
                            classes.add(s);
                            return;
                        }
                    }
                }

                for(String star : starImport){
                    String str = find.GetNameInPackage(className, star);
                    if(str.length() > 0){
                        classes.add(str);
                        return;
                    }
                }
                addOtherClass(className);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addOtherClass(String className){
        String regEx = "[\\[\\]<>]";
        Pattern p= Pattern.compile(regEx);
        Matcher m=p.matcher(className);
        if(!m.find()){
            otherClass.add(className);
        }
    }

    public void setImports(List imports1){
        starImport.add("java.lang");
        for(Object o : imports1){
            if(o.toString().contains("*"))
                starImport.add(((ImportDeclaration)o).getName().toString());
            imports.add(((ImportDeclaration)o).getName().toString());
        }
    }

    public HashSet<String> getClasses() {
        return classes;
    }

    public ArrayList<String> getMethods() {
        return methods;
    }

    public HashSet<String> getOtherClass() {
        return otherClass;
    }
}
