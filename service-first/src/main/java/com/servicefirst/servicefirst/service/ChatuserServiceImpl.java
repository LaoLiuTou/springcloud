package com.servicefirst.servicefirst.service;

import com.servicefirst.servicefirst.entity.Chatuser;
import com.servicefirst.servicefirst.mapper.ChatuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
public class ChatuserServiceImpl implements IChatuserService {

    @Autowired
    private ChatuserMapper chatuserMapper;
    /**
     * 通过id选取
     * @return Chatuser
     */
    @Override
    public Chatuser selectChatuserById(String id) {
        return chatuserMapper.selectChatuserById(id);
    }
    /**
     * 通过查询参数获取信息
     * @return List<Chatuser>
     */
    @Override
    public List<Chatuser> selectChatuserByParam(Map paramMap) {
        return chatuserMapper.selectChatuserByParam(paramMap);
    }
    /**
     * 通过查询参数获取总条数
     * @return int
     */
    @Override
    public int selectCountChatuserByParam(Map paramMap) {
        return chatuserMapper.selectCountChatuserByParam(paramMap);
    }
    /**
     * 更新
     * @return int
     */
    @Override
    @Transactional
    public int updateChatuser(Chatuser chatuser) {
        return chatuserMapper.updateChatuser(chatuser);
    }
    /**
     * 添加
     * @return int
     */
    @Override
    @Transactional
    public int addChatuser(Chatuser chatuser) {
        return chatuserMapper.addChatuser(chatuser);
    }
    /**
     * 批量添加
     * @return int
     */
    @Override
    @Transactional
    public int muladdChatuser(List<Chatuser> list) {
        return chatuserMapper.muladdChatuser(list);
    }
    /**
     * 删除
     * @return int
     */
    @Override
    public int deleteChatuser(String id) {
        return chatuserMapper.deleteChatuser(id);
    }
}
