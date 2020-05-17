package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Factory;

public interface FactoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FACTORY
     *
     * @mbg.generated Sun May 17 16:08:46 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FACTORY
     *
     * @mbg.generated Sun May 17 16:08:46 EEST 2020
     */
    int insert(Factory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FACTORY
     *
     * @mbg.generated Sun May 17 16:08:46 EEST 2020
     */
    Factory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FACTORY
     *
     * @mbg.generated Sun May 17 16:08:46 EEST 2020
     */
    List<Factory> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.FACTORY
     *
     * @mbg.generated Sun May 17 16:08:46 EEST 2020
     */
    int updateByPrimaryKey(Factory record);
}