package cn.edu.upc.hyz.dao;

import cn.edu.upc.hyz.model.WorkPlace;

import java.util.List;

public interface WorkPlaceMapper {

    /**
     * 查询所有项目
     * @return
     */
    List<WorkPlace> selectWorkPlaceList();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    int insert(WorkPlace record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    int insertSelective(WorkPlace record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    WorkPlace selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    int updateByPrimaryKeySelective(WorkPlace record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 31 11:23:10 CST 2020
     */
    int updateByPrimaryKey(WorkPlace record);
    List<WorkPlace> selectWorkPlace();
}