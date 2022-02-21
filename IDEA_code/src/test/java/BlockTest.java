import com.liyujie.container.MsgContainer;
import com.liyujie.redis.MessageDao;
import com.liyujie.service.MessageService;
import com.liyujie.utils.RedisUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisPoolConfig;

public class BlockTest {


    /**
     * Test01:测试AdminUser的登录和更改密码功能
     */
    @Test
    public void Test01()
    {
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
//        AdminUserService adminUserService=(AdminUserService) ctx.getBean("adminUserService");
//        AdminUser user=new AdminUser(0,"admin","123456");
//        System.out.println(adminUserService.validate(user));
//        adminUserService.updatePassword(user.getUsername(),"981027");
//        System.out.println(adminUserService.validate(user));
//        user.setPassword("981027");
//        System.out.println(adminUserService.validate(user));
        String[] beans=ctx.getBeanDefinitionNames();
        for(String bean:beans)
        {
            System.out.println(bean);
        }
    }
    @Test
    public void Test02()
    {
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        String[] AllBeans=ctx.getBeanDefinitionNames();
        for(String bean:AllBeans){
            if(bean.contains("Dao")) System.out.println(bean);
        }
    }

    /**
     * 单例模式的测试模块
     */
    @Test
    public void TestSingleton()
    {
        MsgContainer p1=MsgContainer.getInstance();
        MsgContainer p2=MsgContainer.getInstance();
        System.out.println(p1==p2);
        System.out.println(p1.getMessageMap()==p2.getMessageMap());
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
    }

    @Test
    public void TestRedis()
    {
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        RedisUtil redisUtil=(RedisUtil) ctx.getBean("redisUtil");
        if(redisUtil==null){
            throw new NullPointerException("redisUtil为null");
        }
        redisUtil.lSet("20220212","Msg");
        System.out.println(redisUtil.lGet("20220212",0,-1));
    }

    @Test
    public void TestRedisDao()
    {
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        MessageDao messageDao=(MessageDao) ctx.getBean("messageDao");
        System.out.println(messageDao.getAllMessage("20220212"));
    }

    @Test
    public void TestRedisService()
    {
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        MessageService messageService=(MessageService) ctx.getBean("messageService");
        for(int i=0;i<10;i++){
            messageService.push(20220212,String.valueOf(i));
        }
        System.out.println(messageService.getAll(20220212));
    }

}
