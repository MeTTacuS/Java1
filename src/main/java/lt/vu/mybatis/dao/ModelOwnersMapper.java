package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.ModelOwners;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ModelOwnersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL_OWNERS
     *
     * @mbg.generated Sun May 17 17:28:52 EEST 2020
     */
    int insert(ModelOwners record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MODEL_OWNERS
     *
     * @mbg.generated Sun May 17 17:28:52 EEST 2020
     */
    List<ModelOwners> selectAll();
}