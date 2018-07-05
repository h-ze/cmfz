package test;

import com.hz.cmfz.dao.ManagerDAO;
import com.hz.cmfz.entity.Manager;
import com.hz.cmfz.service.ManagerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 11022 on 2018/7/4 0004.
 */
public class ManagerTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    private ManagerService mgr = (ManagerService) ac.getBean("managerServiceImpl");
    @Test
    public void select(){
        Manager manager=mgr.query("何ze","123456");
                if(manager != null){
                    System.out.println("存在");
                }else
                {
                    System.out.println("不存在");
                }
    }

}
