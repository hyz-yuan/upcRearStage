package cn.edu.upc.manage.dao;

import cn.edu.upc.manage.model.GroupEx;

import java.util.List;

public interface GroupExMapper {

    /**
     * 选取项目内所有小组
     *
     * @param projectId
     * @return
     */
    List<GroupEx> selectGroup(Integer projectId);
    List<GroupEx> selectByPrimaryKey();
    List<GroupEx> updateByPrimaryKeySelect(GroupEx changName);
    int updateDel(GroupEx group);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_ex
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_ex
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int insert(GroupEx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_ex
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int insertSelective(GroupEx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_ex
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    GroupEx selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_ex
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int updateByPrimaryKeySelective(GroupEx record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_ex
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int updateByPrimaryKey(GroupEx record);
}