package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Owner;

public interface OwnerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.OWNER
     *
     * @mbg.generated Sun May 17 17:28:52 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.OWNER
     *
     * @mbg.generated Sun May 17 17:28:52 EEST 2020
     */
    int insert(Owner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.OWNER
     *
     * @mbg.generated Sun May 17 17:28:52 EEST 2020
     */
    Owner selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.OWNER
     *
     * @mbg.generated Sun May 17 17:28:52 EEST 2020
     */
    List<Owner> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.OWNER
     *
     * @mbg.generated Sun May 17 17:28:52 EEST 2020
     */
    int updateByPrimaryKey(Owner record);

    List<Owner> selectOwnersByModel(Integer modelId);
    List<Owner> selectOwnersByModelFree(Integer modelId);
}