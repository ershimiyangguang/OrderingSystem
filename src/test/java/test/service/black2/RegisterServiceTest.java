package test.service.black2;


import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.impl.RegisterServiceImpl;
import org.junit.Test;

import java.io.IOException;

public class RegisterServiceTest {
    // 一个方法代表一个测试用例
    // 方法名为被测试的类名+Test+编号
    @Test
    public void testRegister01() {
        RegisterServiceImpl registerService = new RegisterServiceImpl();

        // 假设这是你的测试数据
        String uname = "";
        String password1 = "1234";
        String password2 = "1234";
        String key = "0";
        String value = "0313";

        try {
            // 调用 register 方法
            Message<User> result = registerService.register(uname, password1, password2, key, value);

            // 处理测试结果
            System.out.println("测试结果：");
            System.out.println(result);
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
        }
    }
    @Test
    public void testRegister02() {
        RegisterServiceImpl registerService = new RegisterServiceImpl();

        // 假设这是你的测试数据
        String uname = "33";
        String password1 = "1234";
        String password2 = "1234";
        String key = "1";
        String value = "0313";

        try {
            // 调用 register 方法
            Message<User> result = registerService.register(uname, password1, password2, key, value);

            // 处理测试结果
            System.out.println("测试结果：");
            System.out.println(result);
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
        }
    }
    @Test
    public void testRegister03() {
        RegisterServiceImpl registerService = new RegisterServiceImpl();

        // 假设这是你的测试数据
        String uname = "33";
        String password1 = "password";
        String password2 = "1234";
        String key = "0";
        String value = "0313";

        try {
            // 调用 register 方法
            Message<User> result = registerService.register(uname, password1, password2, key, value);

            // 处理测试结果
            System.out.println("测试结果：");
            System.out.println(result);
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
        }
    }
    @Test
    public void testRegister04() {
        RegisterServiceImpl registerService = new RegisterServiceImpl();

        // 假设这是你的测试数据
        String uname = "root测试";
        String password1 = "password";
        String password2 = "password";
        String key = "0";
        String value = "0313";

        try {
            // 调用 register 方法
            Message<User> result = registerService.register(uname, password1, password2, key, value);

            // 处理测试结果
            System.out.println("测试结果：");
            System.out.println(result);
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
        }
    }
    @Test
    public void testRegister05() {
        RegisterServiceImpl registerService = new RegisterServiceImpl();

        // 假设这是你的测试数据
        String uname = "test";
        String password1 = "password测试";
        String password2 = "password测试";
        String key = "0";
        String value = "0313";

        try {
            // 调用 register 方法
            Message<User> result = registerService.register(uname, password1, password2, key, value);

            // 处理测试结果
            System.out.println("测试结果：");
            System.out.println(result);
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
        }
    }

}
