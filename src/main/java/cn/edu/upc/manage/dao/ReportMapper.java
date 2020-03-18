package cn.edu.upc.manage.dao;

import cn.edu.upc.manage.model.Report;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int insert(Report record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int insertSelective(Report record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    Report selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int updateByPrimaryKeySelective(Report record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table report
     *
     * @mbg.generated Tue Mar 17 22:10:51 CST 2020
     */
    int updateByPrimaryKey(Report record);
    List<Report> selectReportListByParam(@Param("pid") int pid, @Param("gid") int gid, @Param("eid") int eid);
}