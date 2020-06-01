package junit.test;

import com.ryz.crowdfunding.bean.User;
import com.ryz.crowdfunding.manager.service.UserService;
import com.ryz.crowdfunding.util.MD5Util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/spring*.xml");
        UserService userService = ioc.getBean(UserService.class);

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setLoginacct("test"+i);
            user.setUserpswd(MD5Util.digest("123"));
            user.setUsername("test"+i);
            user.setCreatetime("2020-06-01 18:08:00");
            user.setEmail("test"+i+"@ryz.com");
            userService.saveUser(user);
        }

    }
}
