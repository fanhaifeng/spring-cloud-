package com.tvm.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "myspcloud")
public class OrderProperties {

    private ItemProperties item = new ItemProperties();

}
