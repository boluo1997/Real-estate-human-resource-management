package cn.tedu.search.controller;

import cn.tedu.search.service.IndexService;
import com.jt.common.pojo.MyOrder;
import com.jt.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("search/manage")
public class IndexController {

    @Autowired
    private IndexService is;

    //访问该接口，创建一次索引文件
    @RequestMapping("create/{indexName}")
    public SysResult createIndex(@PathVariable String indexName){
        try{
            is.createIndex(indexName);
            return SysResult.ok();
        }catch(Exception e){
            e.printStackTrace();
            return SysResult.build(201,"",null);
        }
    }

    //实现match_query搜索功能
    @RequestMapping("query")
    public List<MyOrder> query(String text){
        System.out.println("controller");
        return is.query(text);
    }


}

































