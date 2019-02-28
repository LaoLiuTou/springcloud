package com.servicefirst.servicefirst.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.servicefirst.servicefirst.entity.Chatuser;
import com.servicefirst.servicefirst.service.IChatuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class ChatuserController {

    @Autowired
    private IChatuserService iChatuserService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Logger logger = Logger.getLogger("DeerShopLogger");
    @SuppressWarnings({ "rawtypes", "unchecked" })
    //@RequestMapping(value="/addChatuser", produces = MediaType.APPLICATION_XML_VALUE)
    @RequestMapping(value="/addChatuser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map add(Chatuser chatuser){
        Map resultMap=new HashMap();
        try {
            iChatuserService.addChatuser(chatuser);
            resultMap.put("status", "0");
            resultMap.put("msg", chatuser.getId());
            logger.info("新建成功，主键："+chatuser.getId());
        } catch (Exception e) {
            resultMap.put("status", "-1");
            resultMap.put("msg", "新建失败！");
            logger.info("新建失败！"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value="/muladdChatuser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map muladd(HttpServletRequest request, Chatuser chatuser){
        Map resultMap=new HashMap();
        try {
            String data=request.getParameter("data");
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, Chatuser.class);
            List<Chatuser> list = (List<Chatuser>)objectMapper.readValue(data, javaType);
            iChatuserService.muladdChatuser(list);
            resultMap.put("status", "0");
            resultMap.put("msg", "新建成功");
            logger.info("新建成功，主键："+chatuser.getId());
        } catch (Exception e) {
            resultMap.put("status", "-1");
            resultMap.put("msg", "新建失败！");
            logger.info("新建失败！"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value="/deleteChatuser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map delete(Chatuser chatuser){
        Map resultMap=new HashMap();
        try {
            if(chatuser.getId()==null){
                resultMap.put("status", "-1");
                resultMap.put("msg", "参数不能为空！");
            }
            else{
                int resultDelete=iChatuserService.deleteChatuser(chatuser.getId()+"");
                resultMap.put("status", "0");
                resultMap.put("msg", "删除成功！");
                logger.info("删除成功，主键："+chatuser.getId());
            }
        } catch (Exception e) {
            resultMap.put("status", "-1");
            resultMap.put("msg", "删除失败！");
            logger.info("删除失败！"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value="/selectChatuser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map select(Chatuser chatuser){
        Map resultMap=new HashMap();
        try {
            if(chatuser.getId()==null){
                resultMap.put("status", "-1");
                resultMap.put("msg", "参数不能为空！");
            }
            else{
                Chatuser resultSelect=iChatuserService.selectChatuserById(chatuser.getId()+"");
                resultMap.put("status", "0");
                resultMap.put("msg", resultSelect);
            }
        } catch (Exception e) {
            resultMap.put("status", "-1");
            resultMap.put("msg", "查询失败！");
            logger.info("查询失败！"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value="/updateChatuser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map update(Chatuser chatuser){
        Map resultMap=new HashMap();
        try {
            if(chatuser.getId()==null){
                resultMap.put("status", "-1");
                resultMap.put("msg", "参数不能为空！");
            }
            else{
                int resultUpdate=iChatuserService.updateChatuser(chatuser);
                resultMap.put("status", "0");
                resultMap.put("msg", "更新成功！");
                logger.info("更新成功，主键："+chatuser.getId());
            }
        } catch (Exception e) {
            resultMap.put("status", "-1");
            resultMap.put("msg", "更新失败！");
            logger.info("更新失败！"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        return resultMap;
    }
    @RequestMapping(value="/listChatuser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map list(@RequestParam(value = "page", defaultValue = "1") int page,
                    @RequestParam(value = "size", defaultValue = "10") int size,
                    @RequestParam(value = "orderby", defaultValue = "ID DESC") String orderby,
                    HttpServletRequest request, HttpServletResponse response, Chatuser chatuser)
            throws ServletException, IOException, ParseException {
        Map resultMap=new HashMap();

        PageHelper.startPage(page, size,orderby);
        Map paramMap=new HashMap();
        paramMap.put("id",chatuser.getId());
        paramMap.put("userid",chatuser.getUserid());
        paramMap.put("username",chatuser.getUsername());
        paramMap.put("userimage",chatuser.getUserimage());
        String addtimeFrom=request.getParameter("addtimeFrom");
        String addtimeTo=request.getParameter("addtimeTo");
        if(addtimeFrom!=null&&!addtimeFrom.equals(""))
            paramMap.put("addtimeFrom", sdf.parse(addtimeFrom));
        if(addtimeTo!=null&&!addtimeTo.equals(""))
            paramMap.put("addtimeTo", sdf.parse(addtimeTo));
        paramMap.put("detail",chatuser.getDetail());
        paramMap.put("isonline",chatuser.getIsonline());
        paramMap.put("flag",chatuser.getFlag());
        List<Chatuser> list=iChatuserService.selectChatuserByParam(paramMap);
        PageInfo<Chatuser> pageList = new PageInfo<>(list);
        resultMap.put("status", "0");
        resultMap.put("msg", pageList);

        return resultMap;
    }


}
