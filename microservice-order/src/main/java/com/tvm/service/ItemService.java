package com.tvm.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tvm.entity.OrderProperties;
import com.tvm.fhf.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service("orderItemService")
public class ItemService {

    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Autowired
    private RestTemplate restTemplate;

   /* @Value("${myspcloud.item.url}")
    public String itemUrl;*/

   @Autowired
   private OrderProperties orderProperties;


   @HystrixCommand(fallbackMethod = "queryItemIdFallbackMethod")
   public Item queryItemById(Long id) {
       /* return this.restTemplate.getForObject(orderProperties.getItem().getUrl()
                + id, Item.class);*/

        String itemUrl = "http://app-item/item/{id}";
        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        System.out.println("订单系统调用商品服务,result:" + result);
        return result;
    }

    public Item queryItemIdFallbackMethod(Long id){
       return new Item(id,"查询商品信息出错",null,null,null);
    }

}
