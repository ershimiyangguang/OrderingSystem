package cn.edu.cugb.dao;

import cn.edu.cugb.bean.Admin;

public interface AdminDao {
    Admin getAdminByName(String aName);
}
