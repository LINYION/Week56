package com.example.week56.service;


import com.example.week56.bean.Lost;
import com.example.week56.mapper.LostMapper;
import com.example.week56.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class LostService {
    @Autowired
    private LostMapper lostMapper;

    public Result add(Lost lost) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            lostMapper.add(lost);
            result.setMsg("注册成功");
            result.setSuccess(true);
            result.setDetail(lost);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result delete(Long lost_id) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Lost existLost = lostMapper.findLostById(lost_id);
            if(existLost == null){
                result.setMsg("物品不存在");
            }else{
                lostMapper.delete(lost_id);
                result.setMsg("删除成功");
                result.setSuccess(true);
                result.setDetail(lost_id);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result search(Long lost_id) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Lost existLost = lostMapper.findLostById(lost_id);
            if(existLost == null){
                result.setMsg("物品不存在");
            }else{
                Lost lost = lostMapper.search(lost_id);
                result.setMsg("查找成功");
                result.setSuccess(true);
                result.setDetail(lost);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public Result update(Lost lost) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try{
            Lost existLost = lostMapper.findLostById(lost.getLost_id());
            if(existLost == null){
                result.setMsg("物品不存在");
            }else{
                lostMapper.delete(lost.getLost_id());
                lostMapper.add(lost);
                result.setMsg("更改成功");
                result.setSuccess(true);
                result.setDetail(lost);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
