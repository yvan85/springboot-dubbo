package com.zy.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class GetConfigUtil {
    private static Logger logger = LoggerFactory.getLogger(GetConfigUtil.class);
    private static ResourceBundle testProperties = null;

    public static ResourceBundle getTestProperties(String file) {
        if (testProperties != null){
            return testProperties;}
        try {
            testProperties = getProperties(file);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.info("getTestProperties PATH is{}", testProperties);
        }
        return testProperties;
    }

    /**
     * Returns the property defined in test.properties with the specified key.
     */
    public static String getTestProperty(String file, String key) {
        ResourceBundle bundle = getTestProperties(file);
        return bundle.getString(key);
    }

    /**
     * 获取工程根目录地址，根据操作系统、是否打包自动判断
     * 例如编译成war包部署至tomcat目录后，获取到的目录是： /var/apache-tomcat8/webapps/ROOT/WEB-INF/classes/com/tujia/qa/common
     * 通过getBasePath（）方法，获取到的根目录是：/var/apache-tomcat8/webapps/ROOT/WEB-INF/classes
     * <p>
     * 例如在Windows调试环境，获取到的根目录是：    E:\git\QA_AutoTest20181212\target\test-1.0\WEB-INF\classes\com\tujia\qa\common\ConfigInfo.class
     * 通过getBasePath（）方法，获取到的根目录是：  E:\git\QA_AutoTest20181212\
     */
    public static String getBasePath() {
        GetPath getPath = new GetPath();
        String path = getPath.path();
        if (OSUtils.isWindows()) {
            path += "\\";
        } else if (OSUtils.isMacOS() || OSUtils.isLinux()) {
            path += "/";
        }
//        logger.info("BasePath is{}", path);
        return path;
    }

    /**
     * 在getBasePath()基础上，拼接资源文件目录，区分以下三种情况：
     * 1、Windows环境下的资源文件目录（代码调试）
     * 2、Linux环境下，war包部署后资源文件目录（数据构建服务）
     * 3、Linux环境下，非war包部署时的资源文件目录（用于运行test下的测试脚本）
     */
    public static String getResourcesPath() {
        String app_path = GetConfigUtil.getBasePath();
        if (OSUtils.isWindows()) {
            app_path += "src\\main\\resources\\";
        } else if (OSUtils.isMacOS() || OSUtils.isLinux()) {
            if (app_path.contains("webapps")) {
                app_path += "";
            } else if (app_path.contains("maven-workspace")) {
                app_path += "src/main/resources/";
            }
        }
        return app_path;
    }

    /**
     * 在getResourcesPath()基础上，拼接model目录，区分Windows与Linux两种情况
     */
    public static String getModelPath() {
        String resourcesPath = GetConfigUtil.getResourcesPath();
        String modelPath = "";

        if (OSUtils.isWindows()) {
            modelPath = resourcesPath + "model\\";
        } else if (OSUtils.isMacOS() || OSUtils.isLinux()) {
            modelPath = resourcesPath + "model/";
        }
        return modelPath;
    }

    /**
     * 在getModelPath基础上，拼接Model路径+业务系统数据模板路径
     *
     * @param joinPath 例如houseImport/price
     */
    public static String getBizModelPath(String joinPath) {
        String combinationPath = GetConfigUtil.getModelPath();
        if (OSUtils.isWindows()) {
            combinationPath += joinPath + "\\";
        } else if (OSUtils.isMacOS() || OSUtils.isLinux()) {
            combinationPath += joinPath + "/";
        }
        return combinationPath;
    }

    /**
     * 示例：仅用于接入系统的业务数据模板
     * 拼接路径，Model路径+接入系统数据模板路径
     */
    public static String getModelPath_HouseImport() {
        return getBizModelPath("houseImport");
    }

    private static ResourceBundle getProperties(String file) {
        PropertyResourceBundle bundle;
        String path = "";
        try {
            path = getResourcesPath();
            path = path + file + ".properties";
            InputStream in = new BufferedInputStream(new FileInputStream(path));
            bundle = new PropertyResourceBundle(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            logger.info("getModelPath_HouseImport is：{}", path);
        }
        return bundle;
    }
}
