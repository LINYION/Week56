package com.example.week56.mapper;

import com.example.week56.bean.Lost;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LostMapper {
    @Insert(value = "insert into lost(lost_id,lost_name,lost_position,lost_date,lost_description,claim_position,is_returned)" +
            "values " +
            "(#{lost_id},#{lost_name},#{lost_position},#{lost_date},#{lost_description},#{claim_position},#{is_returned)}")
    void add(Lost lost);

    @Select(value = "select * from lost l where l.lost_id=#{lost_id}")
    Lost findLostById(Long lost_id);

    @Delete(value = "delect from lost where lost_id = #{lost_id}")
    void delete(Long lost_id);

    @Select(value = "select * from lost where lost_id = #{lost_id}")
    Lost search(Long lost_id);

}
