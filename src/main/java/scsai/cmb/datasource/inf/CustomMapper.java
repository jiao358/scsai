package scsai.cmb.datasource.inf;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import scsai.cmb.datasource.entity.Custom;
import scsai.cmb.datasource.entity.CustomExample;

public interface CustomMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CUSTOM
	 * @mbg.generated  Sun Apr 02 01:47:30 GMT+08:00 2017
	 */
	long countByExample(CustomExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CUSTOM
	 * @mbg.generated  Sun Apr 02 01:47:30 GMT+08:00 2017
	 */
	int deleteByExample(CustomExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CUSTOM
	 * @mbg.generated  Sun Apr 02 01:47:30 GMT+08:00 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CUSTOM
	 * @mbg.generated  Sun Apr 02 01:47:30 GMT+08:00 2017
	 */
	int insert(Custom record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CUSTOM
	 * @mbg.generated  Sun Apr 02 01:47:30 GMT+08:00 2017
	 */
	int insertSelective(Custom record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CUSTOM
	 * @mbg.generated  Sun Apr 02 01:47:30 GMT+08:00 2017
	 */
	List<Custom> selectByExample(CustomExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CUSTOM
	 * @mbg.generated  Sun Apr 02 01:47:30 GMT+08:00 2017
	 */
	Custom selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CUSTOM
	 * @mbg.generated  Sun Apr 02 01:47:30 GMT+08:00 2017
	 */
	int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CUSTOM
	 * @mbg.generated  Sun Apr 02 01:47:30 GMT+08:00 2017
	 */
	int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CUSTOM
	 * @mbg.generated  Sun Apr 02 01:47:30 GMT+08:00 2017
	 */
	int updateByPrimaryKeySelective(Custom record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CUSTOM
	 * @mbg.generated  Sun Apr 02 01:47:30 GMT+08:00 2017
	 */
	int updateByPrimaryKey(Custom record);
}