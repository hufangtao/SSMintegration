package com.hufangtao.controller;

import com.hufangtao.pojo.Items;
import com.hufangtao.service.ItemsService;
import com.hufangtao.vo.QueryVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ItemsController {

    @Resource(name = "itemService")
    private ItemsService itemsService;

    @RequestMapping("/list")
    public ModelAndView itemsList() throws Exception{
        List<Items> list = itemsService.list();

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("itemList", list);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }

    @RequestMapping("/itemEdit")
    public String itemEdit(HttpServletRequest request, HttpServletResponse response,
                           HttpSession session, Model model) throws Exception{
        String str = request.getParameter("id");
        Items item = itemsService.findItemById(Integer.parseInt(str));

        //使用request来扩展
        model.addAttribute("item",item);

        //如果springmvc返回的是string，那么springmvc就会认为这个字符串就是页面的名称
        return "editItem";
    }

    @RequestMapping("/updateitem")
    public String update(Integer id,String name,Float price,String detail) throws Exception{
        Items items=new Items();
        items.setId(id);
        items.setPrice(price);
        items.setDetail(detail);
        items.setName(name);
        items.setCreatetime(new Date());
        itemsService.updateItems(items);
        return "success";
    }

    @RequestMapping("/search")
    public String search(QueryVo vo) throws Exception{
        System.out.println(vo);
        return "";
    }

//    @Test
//    public void test(){
//        String[] split = "sss".split(";");
//        for (String s:split){
//            System.out.println("test: "+s);
//        }
//    }

}
