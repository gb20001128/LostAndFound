package com.clj.controller;

import com.clj.dataSources.DataItem;
import com.clj.dataSources.UserDataSource;
import com.clj.domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description
 * @Author gb
 * @Data 2022/8/17 22:59
 */

@Controller
public class controller {


    @GetMapping("/")
    public String index(Model model){


        ArrayList<Item> list = DataItem.list;
        ArrayList<Item> listCopy = new ArrayList<>();
        for (Item item : list) {
            listCopy.add(item);
        }

        Collections.reverse(listCopy);
        int count=list.size();

        model.addAttribute("list",listCopy);

        model.addAttribute("count",count);

        return "home";
    }


    @GetMapping("/lostAndFound")
    public String lostAndFound(){
        return "upload";
    }


    @GetMapping("/aboutUs")
    public String aboutUs(){
        return "aboutus";
    }



    @PostMapping("/upThis")
    public String upThis(MultipartFile photo,String content,String number,String place){

        Item item = new Item();

        //获得上传文件的名称
        String filename = photo.getOriginalFilename();
        System.out.println("图片的原始名字: " + filename);
        //创建UUID,用来保持文件名字的唯一性
        String uuid = UUID.randomUUID().toString().replace("-","");
        //uuid太长,截一部分
        uuid=uuid.substring(27);
        //进行文件名称的拼接
        String newFileName = uuid+".png";
        //创建文件实例对象
        File uploadFile = new File("F:\\apache-tomcat\\webapps\\item\\",newFileName);
        //判断当前文件是否存在

        //执行文件上传的命令
        try {
            photo.transferTo(uploadFile);
        } catch (IOException e) {
            return null;
        }

        item.setPhotoName(newFileName);
        item.setContent(content);
        item.setNumber(number);
        item.setPlace(place);

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy年MM月dd日-HH时mm分");
        Date date = new Date();
        String time = formatter.format(date);
        item.setTime(time);


        DataItem.list.add(item);




        return "redirect:/";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(String userName, String passWord, HttpSession session,Model model){

        boolean b = UserDataSource.existUser(userName, passWord);

        if (b) {
            session.setAttribute("userName", userName);

            return "redirect:/";
        }

        else {
            model.addAttribute("msg","账号密码错误！");
            return "login";
        }
    }




}
