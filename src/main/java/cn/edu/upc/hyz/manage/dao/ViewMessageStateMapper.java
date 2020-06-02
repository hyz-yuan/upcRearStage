package cn.edu.upc.hyz.manage.dao;

import cn.edu.upc.hyz.manage.model.ViewMessageState;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewMessageStateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_message_state
     *
     * @mbg.generated Thu Mar 19 18:18:19 CST 2020
     */
    int insert(ViewMessageState record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table view_message_state
     *
     * @mbg.generated Thu Mar 19 18:18:19 CST 2020
     */
    int insertSelective(ViewMessageState record);

    List<ViewMessageState> getMessageList(@Param("UserId") Integer UserId);
}