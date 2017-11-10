package com.gaofei.web.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by GaoQingming on 2017/9/4 0004.
 */
public class MyProperties {
    private static Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(MyProperties.class);

    String defaultTest = "default";
    protected String protectedTest = "protected";
    static {
        String url = "properties/testproperties.properties";
        try {
            String testUrl = MyProperties.class.getClassLoader().getResource("properties/testproperties.properties").getPath();
            logger.info("testUrl : " + testUrl);
            InputStream inputStream = MyProperties.class.getClassLoader().getResourceAsStream("properties/testproperties.properties");
            //FileInputStream fileInputStream = new FileInputStream(url);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            properties.load(bufferedReader);
        } catch (FileNotFoundException e) {
            logger.warn("fileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            logger.warn("ioException");
            e.printStackTrace();
        }
    }

    public static String getProperty (String property) {
        if (property == null) {
            return null;
        } else {
            return properties.getProperty(property);
        }
    }
}
