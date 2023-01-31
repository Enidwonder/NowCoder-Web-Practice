package MapperTest;

import com.wsj.mvnWebPractice.MvnWebPracticeApplication;
import com.wsj.mvnWebPractice.dao.UserMapper;
import com.wsj.mvnWebPractice.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = MvnWebPracticeApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setActivationCode("7899");
        user.setUsername("helo");
        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

}
