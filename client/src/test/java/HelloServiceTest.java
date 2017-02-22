import com.rpc.client.RpcProxy;
import com.rpc.commons.InstanceService;
import com.rpc.interf.HelloService;
import com.rpc.interf.TestModelService;
import com.rpc.test.model.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/2/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class HelloServiceTest {

    @Autowired
    private RpcProxy rpcProxy;
    @Autowired
    private InstanceService instanceService;

    /*
      *  返回字符串
     */
    @Test
    public void helloTest() {
        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.hello("World");
        // Assert.assertEquals("Hello! World", result);
        System.out.println("----------" + result);
    }
    /*
     * 返回实体
     */
    @Test
    public void testModel() {
        TestModelService testModelService = rpcProxy.create(TestModelService.class);
        UserModel userModel = testModelService.getUserModel();
        System.out.println("********" + userModel);
    }

    @Test
    public void instanceService() {
        instanceService.getAllInterface();
    }
}
