package core.ref;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.model.Question;
import next.model.User;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void showClass() {
        Class<Question> clazz = Question.class;
        logger.debug(clazz.getName());
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
        	logger.debug("field : {}, type : {}, modifier : {}", 
        			field.getName(), field.getType(), field.getName());
        }
    }
    
    @Test
    public void newInstanceWithConstructorArgs() throws Exception
    {
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());
        Constructor[] cons = clazz.getDeclaredConstructors();
        for (Constructor constructor : cons) {
        	logger.debug("con :{}", constructor);
        	User user = (User)constructor.newInstance("ogany", "passok", "장옥원", "ogany@naver.com");        	
        }
        
    }
    
    @Test
    public void privateFieldAccess() throws Exception {
        Class<Student> clazz = Student.class;
        logger.debug(clazz.getName());
        Student student = new Student();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(student, "옥원");
        logger.debug("name : {}", student.getName());
    }
}
