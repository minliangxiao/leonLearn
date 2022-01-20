package com.example.alip6.design_pattern.observer.start;

import com.example.alip6.design_pattern.observer.MySubject;
import com.example.alip6.design_pattern.observer.Observer;
import com.example.alip6.design_pattern.observer.impl.EmailObserver;
import com.example.alip6.design_pattern.observer.impl.SMSObserver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.xml.ws.Action;
import java.util.Map;

/**
 * 项目启动就将业务模型注册到观察者list中  这样写的原因是为了避免spring容器加载顺序  ApplicationContextAware接口能够获取到spring容器的上下文对象
 */
@Component
public class StartService implements ApplicationRunner, ApplicationContextAware {
    @Autowired
    private EmailObserver emailObserver;
    @Autowired
    private SMSObserver smsObserver;
    @Autowired
    private MySubject  mySubject;

    private ApplicationContext applicationContext;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*mySubject.addObserver(emailObserver);
        mySubject.addObserver(smsObserver);*/
        /*
        * 实现自动注册观察者
        * 1.使用spring获取该Observer下的所有那些bean对象（也可用反射获取Observer接口下面的所有实现类）
        * 2.将获取到的对象注入
        * */
        Map<String, Observer> beans = applicationContext.getBeansOfType(Observer.class);
        beans.forEach((k,v)->{
            mySubject.addObserver(v);
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
