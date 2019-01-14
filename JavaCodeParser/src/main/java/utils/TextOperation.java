package utils;

import data.Answer;
import data.Question;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parse.Parser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class TextOperation {
    private HashMap<String, Integer> packageMap = new HashMap<>();
    private HashMap<Integer, Question> questions = new HashMap<>();
    private HashSet<Answer> answers = new HashSet<>();

    /*
     * Text Clean Rules
     */
    public String convertSymbol(String javaCode){
        String str = javaCode.replace("&quot;", "\"")
                .replaceAll("&amp;lt;", "<")
                .replaceAll("&amp;gt;", ">")
                .replaceAll("&lt;", "<")
                .replaceAll("&gt;", ">")
                .replaceAll("\\.\\.\\.", "");
        return str;
    }

    // 代码加壳，类
    public static String addClass(String javaCode){
        return "public class MyClass{" + javaCode + "}";
    }

    // 代码加壳，类+方法
    public static String addMethdAndClass(String javaCode){
        return "public class MyClass{" +
                "public static void main(String[] args){" +
                javaCode +
                "}}";
    }

    //
    public void getCodeFromXml(String fileName){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);
            NodeList codeList = document.getElementsByTagName("code");
            System.out.println("Size: "+codeList.getLength());
            for(int i = 0;i < codeList.getLength();i++){
                System.out.println(codeList.item(i).getTextContent());
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void analysisPostFromXml(String fileName){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);
            NodeList postList = document.getElementsByTagName("post");
            Parser parser = new Parser();
            for(int i = 0;i < postList.getLength();i++){
                String qid = postList.item(i).getAttributes().getNamedItem("qid").getNodeValue();
                String aid = postList.item(i).getAttributes().getNamedItem("aid").getNodeValue();
                boolean isQuestion = false;
                boolean hasJCode = false;

                if(aid.equals("0")){
                    isQuestion = true;
                }
                NodeList childlist = postList.item(i).getChildNodes();
                for(int j = 0;j < childlist.getLength();j++){
                    if(childlist.item(j).getNodeType() == Node.ELEMENT_NODE){
                        String javaCode = childlist.item(j).getTextContent();
                        if(analysisJavaCode(javaCode, parser)){
                            hasJCode = true;
                        }
                    }
                }
                if(isQuestion){
                    Question q = new Question();
                    q.setQid(Integer.valueOf(qid));
                    q.setqHasJCode(hasJCode);
                    questions.put(Integer.valueOf(qid), q);
                } else {
                    Question q = questions.get(Integer.valueOf(qid));
                    if(q == null) {
                        q = new Question();
                        q.setQid(Integer.valueOf(qid));
                        questions.put(Integer.valueOf(qid), q);
                    }

                    q.getAidList().add(Integer.valueOf(aid));
                    if(hasJCode){
                        int aHasCode = q.getaHasCode();
                        q.setaHasCode(aHasCode+1);
                    } else {
                        int aHasNoCode = q.getaHasNoCode();
                        q.setaHasNoCode(aHasNoCode+1);
                    }
                }
            }
            System.out.println("AllClass: "+parser.getClassCountMap()
                    + ", " + parser.getClassCountMap().size());
            System.out.println("otherClass: "+parser.getOtherClassCountMap()
                    + ", " + parser.getOtherClassCountMap().size());
            sortHashMap(parser.getOtherClassCountMap());
            analysisPackage(parser.getClassCountMap());
            System.out.println(questions + ", " + questions.size());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void analysisCodeFromXml(String fileName){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        int nonCode = 0;

        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);
            NodeList codeList = document.getElementsByTagName("code");
            System.out.println("Size: "+codeList.getLength());
            Parser parser = new Parser();
            for(int i = 0;i < codeList.getLength();i++){
                String javaCode = codeList.item(i).getTextContent();

                if(!analysisJavaCode(javaCode, parser)){
                    nonCode++;
                }
            }
            System.out.println("AllClass: "+parser.getClassCountMap()
                    + ", " + parser.getClassCountMap().size());
            System.out.println("otherClass: "+parser.getOtherClassCountMap()
                    + ", " + parser.getOtherClassCountMap().size());
            System.out.println("NonCode: "+nonCode);
            analysisPackage(parser.getClassCountMap());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 分析一段代码是不是java代码段
     * yes - true, no - false
     *
     */
    public boolean analysisJavaCode(String javaCode, Parser parser){
        boolean sign = true;
        javaCode = convertSymbol(javaCode);
        System.out.println(javaCode);
        if(parser.parse(javaCode) != null){
            System.out.println("Origin is JavaCode...");

        } else if(parser.parse(TextOperation.addClass(javaCode)) != null){
            System.out.println("Add Class is JavaCode...");

        } else if(parser.parse(TextOperation.addMethdAndClass(javaCode)) != null){
            System.out.println("Add Class&Method is JavaCode...");
        } else {
            System.out.println("Not a JavaCode...");
            sign = false;
        }
        System.out.println("-------------------------------\n");
        return sign;
    }

    /*
     * 分析获得类名的包分布
     */
    private void analysisPackage(HashMap<String, Integer> classMap){
        for(String key : classMap.keySet()){
            int value = classMap.get(key);
            key = key.substring(0, key.lastIndexOf('.'));
            int num = packageMap.getOrDefault(key, 0);
            packageMap.put(key, num+value);
        }
        Printer.println(packageMap);
        sortHashMap(packageMap);
    }

    private void sortHashMap(HashMap<String, Integer> map){
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });
        int index = 0;
        for(Map.Entry<String, Integer> t:list){
            if(index == 100)
                break;
            System.out.println(index + ": " + t.getKey()+":"+t.getValue());
            index++;
        }
    }
}
