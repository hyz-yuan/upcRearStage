package cn.edu.upc.manage.dao;

import cn.edu.upc.manage.model.WorkPlace;

public interface WorkPlaceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int insert(WorkPlace record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int insertSelective(WorkPlace record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    WorkPlace selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int updateByPrimaryKeySelective(WorkPlace record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_place
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int updateByPrimaryKey(WorkPlace record);
}