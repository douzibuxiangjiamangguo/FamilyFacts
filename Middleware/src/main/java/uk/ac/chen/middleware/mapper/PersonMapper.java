package uk.ac.chen.middleware.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import uk.ac.chen.middleware.entity.PersonEntity;

/**
 * @author: Qiuyu
 */
@Repository
public interface PersonMapper extends BaseMapper<PersonEntity> {

    /**
     * Insert Person
     * @param sex
     */
    void addPerson(@Param("Sex") Integer sex);
}
