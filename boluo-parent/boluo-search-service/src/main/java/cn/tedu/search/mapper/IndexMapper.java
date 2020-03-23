package cn.tedu.search.mapper;

import com.jt.common.pojo.MyOrder;
import com.jt.common.pojo.Salesman;

import java.util.List;

public interface IndexMapper {
    List<MyOrder> selectMyOrder();
}

