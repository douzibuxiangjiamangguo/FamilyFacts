package uk.ac.chen.middleware.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import uk.ac.chen.middleware.entity.PersonEntity;

/**
 * @author: Qiuyu
 */
@Repository
public interface PersonMapper extends BaseMapper<PersonEntity> {
}
