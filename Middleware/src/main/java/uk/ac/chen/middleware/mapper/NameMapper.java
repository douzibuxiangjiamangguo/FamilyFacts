package uk.ac.chen.middleware.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import uk.ac.chen.middleware.entity.NameEntity;

/**
 * @author: Qiuyu
 */
@Repository
public interface NameMapper extends BaseMapper<NameEntity> {

    /**
     * Get Name by full name
     * @param firstName
     * @param lastName
     * @return
     */
    NameEntity getNameByFullName(@Param("Given") String firstName, @Param("Surname") String lastName);
}
