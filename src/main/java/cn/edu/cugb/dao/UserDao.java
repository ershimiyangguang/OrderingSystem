package cn.edu.cugb.dao;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;

public interface UserDao {
    /*查询User
    * 参数: User的id
    * 存在返回User
    * 不存在返回null*/
    User getUserById(Integer uid);

}
