package cn.edu.cugb.dao;

import cn.edu.cugb.bean.User;

public interface UserDao {
<<<<<<< Updated upstream
    /*查询User
    * 参数: User的id
    * 存在返回User
    * 不存在返回null*/
    Message<User> getUserById(String uid);
=======
    User getUserByName(String uname);

    boolean addUser(User user);
>>>>>>> Stashed changes
}
