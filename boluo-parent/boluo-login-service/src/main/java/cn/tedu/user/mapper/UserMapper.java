package cn.tedu.user.mapper;

import com.jt.common.pojo.Salesman;
import com.jt.common.pojo.User;

public interface UserMapper {


    int selectUserCountBysalesmanName(String salesmanName);

    void insertUser(Salesman salesman);

    Salesman selectUserBysalesNameAndPassword(Salesman salesman);
}
