package com.zy.springboot.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class GetPath {
    private String app_path = null;
    private static Logger logger = LoggerFactory.getLogger(GetPath.class);

    /**
     * 获取各环境当前的根目录
     * */
    public String path() {
        File f = new File(this.getClass().getResource("").getPath());
        if (OSUtils.isMacOS() || OSUtils.isLinux()) {
            app_path = f.getPath().split("/com")[0];
//            logger.info("BasePath is{}", app_path);
        } else if (OSUtils.isWindows()) {
            app_path = f.getPath().split("\\\\target")[0];
        }
        return app_path;
    }
}
