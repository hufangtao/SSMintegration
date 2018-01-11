package com.hufangtao.service;

import com.hufangtao.dao.ItemsMapper;
import com.hufangtao.pojo.Items;
import com.hufangtao.pojo.ItemsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("itemService")
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> list() throws Exception {
        ItemsExample example = new ItemsExample();
        List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
        return list;
    }

    @Override
    public Items findItemById(Integer id) throws Exception {
        Items items = itemsMapper.selectByPrimaryKey(id);
        return items;
    }

    @Override
    public void updateItems(Items items) throws Exception {
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }


}
