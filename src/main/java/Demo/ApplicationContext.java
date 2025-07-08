package Demo;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext implements BeanFactory{
    //definitions存放对象，key为对象名，value为对象
    Map<String,Object> definitions = new HashMap<>();
    @Override
    public Object getBean(String beanName) {
        return definitions.get(beanName);
    }
    //创建指定包名下类对象并保存对象
    public ApplicationContext(String basePackage){
        File basePackagePath = getBeanPackagePath(basePackage);
        classLoader(basePackagePath);
        injection();
    }
    //获取类的根目录
    private String getRootPath(){
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        return url.getPath();
    }
    //将包转换为类的绝对路径（找文件需要绝对路径）,即将包转换为文件夹
    private File getBeanPackagePath(String basePackage){
        String basePackagePath = basePackage.replaceAll("\\.","/");
        String pathName = getRootPath() + basePackagePath;
        File path = new File(pathName);
        return path;
    }
    //将标注了@Instance注解的类，在容器创建对象
    private void classLoader(File path){
        //获取路径下所有内容
        File[] items = path.listFiles();
        //若为空返回，否则遍历文件夹下所有内容
        if(items ==null || items.length == 0){
            return;
        }
        for (File item: items){
            //若为文件夹，递归，否则加载类
            if(item.isDirectory()){
                classLoader(item);
            }else {
                //定义类
                classDefine(item);
            }
        }
    }
    //创建对象
    private void classDefine(File file){
        String fUllName = file.getAbsolutePath().substring(getRootPath().length()-1);
        if(fUllName.contains(".class")){
            fUllName = fUllName.replaceAll("\\\\","\\.")
                    .replace(".class","");
            String beanName = fUllName.substring(fUllName.lastIndexOf(".")+1);
            beanName = beanName.substring(0,1).toLowerCase()+beanName.substring(1);
            try{
                Class clazz = Class.forName(fUllName);
                Object object = doCreateBean(beanName,clazz);
                if(object!=null){
                    definitions.put(beanName,object);
                }
            }catch (ClassNotFoundException e){
                throw new RuntimeException(e);
            }
        }
    }
    private Object doCreateBean(String beanName,Class<?> clazz){
        Instance annotation = clazz.getAnnotation(Instance.class);
        if(annotation!=null && !definitions.containsKey(beanName)){
            try{
                Object object = clazz.getDeclaredConstructor().newInstance();
                return object;
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
    private void injection(){
        for(String beanName : definitions.keySet()){
            Object object = definitions.get(beanName);
            Class clazz = object.getClass();
            Field[] declaredFields = clazz.getDeclaredFields();
            for(Field field : declaredFields){
                AutoDi autoDi = field.getAnnotation(AutoDi.class);
                if(autoDi != null){
                    try {
                        field.setAccessible(true);
                        String feildName = field.getName();
                        if(field.getType().isInterface()){
                            feildName = feildName+"Impl";
                        }
                        field.set(object,definitions.get(feildName));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
