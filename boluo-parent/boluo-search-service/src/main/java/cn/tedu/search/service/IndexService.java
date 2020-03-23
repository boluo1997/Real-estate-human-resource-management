package cn.tedu.search.service;

import cn.tedu.search.mapper.IndexMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jt.common.pojo.MyOrder;
import com.jt.common.pojo.Salesman;
import com.jt.common.utils.MapperUtil;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexService {

    @Autowired
    private IndexMapper im;

    @Autowired
    private TransportClient client;

    public void createIndex(String indexName) throws JsonProcessingException {
        //判断是否存在索引
        IndicesExistsResponse response = client.admin().indices().
                prepareExists(indexName).get();

        if(!response.isExists()){
            client.admin().indices().prepareCreate(indexName).get();
        }
        //整理数据源数据 写入到索引文件中创建文档
        List<MyOrder> pList = im.selectMyOrder();
        //循环plist 解析json 写入索引文件
        for(MyOrder p:pList){
            String json = MapperUtil.MP.writeValueAsString(p);

            //document的id只要保证全局唯一即可
            IndexRequestBuilder request1 =
                    client.prepareIndex(indexName,
                    "myorder", String.valueOf(p.getMyorderId()));
            //封装source 发送请求 写入索引
            request1.setSource(json).get();
        }
    }


    public List<MyOrder> query(String text) {
        try{
            //构造查询query对象
            MatchQueryBuilder query = QueryBuilders.matchQuery("myorderCity",text);
            //搜索
            SearchRequestBuilder request = client.prepareSearch("index01");
            //设置搜索参数
            request.setQuery(query);

            //发送请求从索引获取数据解析
            SearchResponse response = request.get();
            System.out.println("总条数："+response.getHits().getHits());

            //获取source元素
            SearchHit[] hits = response.getHits().getHits();
            List<MyOrder> pList = new ArrayList<MyOrder>();
            for(SearchHit hit:hits){
                //获取source as String
                String JSON = hit.getSourceAsString();
                MyOrder mo = MapperUtil.MP.readValue(JSON,MyOrder.class);
                pList.add(mo);
            }
            return pList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}





































