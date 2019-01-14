package com.tvm.fhf.controller;

import com.tvm.fhf.entity.Item;
import com.tvm.fhf.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value="item/{id}")
    public Item queryItemById(@PathVariable("id") Long id){
        return this.itemService.queryItemById(id);
    }
}
