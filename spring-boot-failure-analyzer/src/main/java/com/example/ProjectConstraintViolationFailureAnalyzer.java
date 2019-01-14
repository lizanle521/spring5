package com.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * 启动异常原因分析类,原理就是 关注项目中的特殊的异常 。
 *
 * @author lizanle
 * @data 2019/1/14 下午4:32
 */
public class ProjectConstraintViolationFailureAnalyzer extends AbstractFailureAnalyzer
                implements BeanFactoryAware,EnvironmentAware {

    private BeanFactory beanFactory;

    private Environment environment;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, Throwable cause) {
        return null;
    }
}
