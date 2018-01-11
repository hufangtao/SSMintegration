package com.hufangtao.service;

import com.hufangtao.pojo.Items;

import java.util.List;

public interface ItemsService {

    public List<Items> list() throws Exception;
    public Items findItemById(Integer id) throws Exception;
    public void updateItems(Items items) throws Exception;
}
