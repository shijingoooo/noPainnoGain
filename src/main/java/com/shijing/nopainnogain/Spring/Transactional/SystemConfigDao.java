package com.shijing.nopainnogain.Spring.Transactional;

import org.springframework.data.repository.CrudRepository;

/**
 * @Auther: shijing
 * @Date: 19/7/3 15:21
 * @Description: SystemConfigDao
 */
public interface SystemConfigDao extends CrudRepository<SystemConfig, Long> {

    SystemConfig findByScode(String sscode);

}
