package cn.tedu.user.mapper;

import com.jt.common.pojo.MyOrder;
import com.jt.common.pojo.Salesman;
import com.jt.common.vo.SysResult;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    Salesman selectSalesmanById(@Param("salesmanId") Integer salesmanId);

    SysResult alterInfo(Salesman salesman);

    void insertOrder(MyOrder myOrder);


    void updateUserById(@Param("salesmanId") Integer salesmanId);

    void updateUserQuitById(@Param("salesmanId") Integer salesmanId);



}
