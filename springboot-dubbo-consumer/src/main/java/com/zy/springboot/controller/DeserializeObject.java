package com.zy.springboot.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class DeserializeObject {
    private static Logger logger = LoggerFactory.getLogger(DeserializeObject.class);

    /**
     * 已有model目录
     * 从文件中读取，并反序列化成特定的数据模型
     *
     * 。00.
     *
     * @param bizPath
     * @param fileName
     * @param cls
     */
    public static <T> T deserializeObjFromFile(String bizPath, String fileName, Class<T> cls) {
        //系统路径
        String app_path = GetConfigUtil.getBizModelPath(bizPath);
        String filePath = app_path + fileName;
        String buffer = FileRW.readFile(filePath);

        T descObject = JSON.parseObject(buffer, cls);

        return descObject;
    }

    /**
     * 将String 反序列化成特定的数据模型
     *
     * @param res
     * @param cls
     */
    public static <T> T deserializeObjFromObject(String res, Class<T> cls) {
        T descObject = JSON.parseObject(res, cls);
        return descObject;
    }

    /**
     * 数据模型
     */
    public static <T> T deserializeObjFromFile(String fileName, Class<T> cls) {
//        String path = "/model/";
        String path = "";
        return deserializeObjFromFile(path,fileName, cls);
    }


    /**
     * 从xml中读取数据到模板对象中
     *
     * @param path
     * @param fileName
     * @param cls
//     * @param <T>
     * @return
     * @throws JAXBException
     * @author leileiy
     */
    public static Object beanXMLFromFile(String path, String fileName, Class<?> cls) throws JAXBException {
        //        String app_path = GetConfigUtil.getBasePath();
        String app_path = GetConfigUtil.getBizModelPath(path);
        String filePath = app_path + fileName;
        String buffer = FileRW.readFile(filePath);

        JAXBContext context = JAXBContext.newInstance(cls);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(buffer);
        Object xmlObject = unmarshaller.unmarshal(reader);

        return xmlObject;
    }

    /**
     * 将实体类转化为xml输出
     *
     * @param beanXML
     * @param load
     * @return
     * @throws JAXBException
     * @author leileiy
     */
    public static String beanToXml(Object beanXML, Class<?> load) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(load);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        StringWriter writer = new StringWriter();
        marshaller.marshal(beanXML, writer);
        return writer.toString();

    }

    /**
     * 从文件中读取，并反序列化成特定的数据模型
     *
     * @param fileName
     */
    public static String readModelFile(String fileName) {
        //系统路径
        String app_path = GetConfigUtil.getModelPath();
        String filePath = app_path + fileName;
        logger.info("filePathIs{}", filePath);
        String buffer = FileRW.readFile(filePath);
        return buffer;
    }



    /**
     * 数据模型
     * @author leileiy
     */
    public static Object beanXMLFromFile(String fileName, Class<?> cls) throws JAXBException {
        String path = "";
        return beanXMLFromFile(path, fileName, cls);
    }


    /**
     * @param clsName
     * @param methodName
     * 通过方法名（成员key），获取方法值(成员value)
     */
    public static <T> String getValuexxxxx(Class<T> clsName, String methodName) throws Exception {
        String fileName = "act/buildOneAct.json";

        methodName = descMethodName(methodName);

        T deserialize = deserializeObjFromFile(fileName, clsName);
        Class cls = deserialize.getClass();
        Method clsmethod = cls.getDeclaredMethod("get" + methodName);
        clsmethod.invoke(deserialize);
        System.out.println(clsmethod.invoke(deserialize));
        return clsmethod.invoke(deserialize).toString();
    }


    /**
     * @param deserialize
     * @param methodName  获取对象实例中的值
     */
    public static <T> String getDeserializeObjectValue(T deserialize, String methodName) {
        try {
            Class cls = deserialize.getClass();
            methodName = descMethodName(methodName);
            Method clsmethod = cls.getDeclaredMethod("get" + methodName);
            clsmethod.invoke(deserialize);
            return clsmethod.invoke(deserialize).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * @param deserialize
     * @param methodName
     * @param setValue    设置对象实例中的值
     */
    public static <T> Method setDeserializeObjectValue(T deserialize, String methodName, String setValue) {
        Method clsma = null;
        try {
            methodName = descMethodName(methodName);

            Class cls = deserialize.getClass();
            clsma = cls.getDeclaredMethod("set" + methodName, String.class);
            clsma.invoke(deserialize, setValue);
            logger.info("setValue is{}",setValue);
            return clsma;
        } catch (Exception e) {
        }
        return clsma;
    }

    /**
     * 通过方法名（成员Key），设置方法值(成员Value)
     * */
    public static <T> Method setValuexxxxxx(Class<T> clsName, String methodName, String setValue) throws Exception {
        String fileName = "act/buildOneAct.json";
        methodName = descMethodName(methodName);
        T deserialize = deserializeObjFromFile(fileName, clsName);
        Class cls = deserialize.getClass();
        Method clsma = cls.getDeclaredMethod("set" + methodName, String.class);
        clsma.invoke(deserialize, setValue);

        return clsma;
    }

    /**
     * 通过方法名，反射获取方法
     * */
    public static String descMethodName(String methodName) {
        StringBuilder name = new StringBuilder();
        String namePart0 = methodName.substring(0, 1).toUpperCase();
        String namePart1 = methodName.substring(1);
        String newName = name.append(namePart0 + namePart1).toString();
        return newName;
    }
}