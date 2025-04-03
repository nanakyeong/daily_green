package beandefinition;

import com.example.springboot.order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    GenericXmlApplicationContext context = new GenericXmlApplicationContext("appconfig.xml");

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplication() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = context.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                System.out.println("beanDefinition = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
            }
        }
    }
}
