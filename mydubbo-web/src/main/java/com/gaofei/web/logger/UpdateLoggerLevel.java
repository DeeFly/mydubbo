package com.gaofei.web.logger;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 成功了，只是没有容错处理，可以检测到修改，并修改日志级别
 * Created by GaoQingming on 2018/2/2 0002.
 */
@Component
public class UpdateLoggerLevel implements InitializingBean {
    private static final Level DEFAULT_LEVEL = Level.INFO;
    private String rootLogLevel = DEFAULT_LEVEL.levelStr;
    private Logger logger = LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
    private ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);


    private void updateLoggerLevel() {
        if (logger instanceof ch.qos.logback.classic.Logger) {
            ch.qos.logback.classic.Logger tLogger = (ch.qos.logback.classic.Logger) logger;
            Level level = Level.toLevel(rootLogLevel, DEFAULT_LEVEL);
            logger.warn("日志级别修改为:{}",rootLogLevel);
            tLogger.setLevel(level);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadProperties();
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                detectChange();
            }
        }, 1,5, TimeUnit.SECONDS);
    }

    private void loadProperties() {
        try(InputStream inputStream= UpdateLoggerLevel.class.getClassLoader().getResourceAsStream("properties/updateLogger.properties");
            BufferedReader bf= new BufferedReader(new InputStreamReader(inputStream))) {
            String temp;
            String tempLevel;
            while ((temp = bf.readLine()) != null) {
                if (temp.startsWith("logger.level")) {
                    tempLevel = temp.substring(temp.indexOf("=") + 1).trim();
                    logger.error("检测到的值为:{}",tempLevel);
                    if (!tempLevel.equals(getRootLogLevel())) {
                        setRootLogLevel(tempLevel);
                        updateLoggerLevel();
                    }
                }
            }
        } catch (Exception e) {
            logger.warn("加载updateLogger.properties失败！");
        }
    }

    private void detectChange() {
        logger.error("detectChange...");
        loadProperties();
    }

    public String getRootLogLevel() {
        return rootLogLevel;
    }

    public void setRootLogLevel(String rootLogLevel) {
        this.rootLogLevel = rootLogLevel;
    }
}
