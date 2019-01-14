package utils;

import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.ArrayList;

public class FindApi {
    public static ClassPath classPath = null;

    public ArrayList<String> GetPackageName(String className) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        if(classPath == null){
            classPath = ClassPath.from(ClassLoader.getSystemClassLoader());
        }

        // TODO: Interface获取不到
        for(ClassPath.ClassInfo info : classPath.getTopLevelClasses()){
            if(info.toString().startsWith("java") || info.toString().startsWith("javax")) {
                String infoStr = info.toString();
                if(infoStr.substring(infoStr.lastIndexOf(".")+1, infoStr.length()).equals(className)){
                    //System.out.println("info:"+info.getPackageName());
                    result.add(info.toString());
                }
            }
        }

        return result;
    }

    public String GetNameInPackage(String className, String packageName) throws IOException {
        if(classPath == null)
            classPath = ClassPath.from(ClassLoader.getSystemClassLoader());
        String name = "";
        for(ClassPath.ClassInfo info : classPath.getTopLevelClasses(packageName)) {
            String infoStr = info.toString();
            if (infoStr.substring(infoStr.lastIndexOf(".") + 1, infoStr.length()).equals(className)) {
                name = info.toString();
                break;
            }
        }
        return name;
    }
}
