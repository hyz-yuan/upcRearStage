package cn.edu.upc.manage.dao;

import cn.edu.upc.manage.model.EmployeeSelect;
import cn.edu.upc.manage.model.EmployeeSelectInput;
import cn.edu.upc.manage.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 19 22:18:47 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 19 22:18:47 CST 2020
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 19 22:18:47 CST 2020
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 19 22:18:47 CST 2020
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 19 22:18:47 CST 2020
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Thu Mar 19 22:18:47 CST 2020
     */
    int updateByPrimaryKey(User record);
    List<EmployeeSelect> selectAll();
    EmployeeSelect selectByName(EmployeeSelectInput employeeSelectInput);

    //董志涵
    public User selectByUsername(@Param("username") String username);

    public void changePasswordByEmail(@Param("newPassword") String newPassword,@Param("email") String email);

    public User selectByEmail(@Param("email") String email);
}