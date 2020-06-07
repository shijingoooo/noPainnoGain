package com.shijing.nopainnogain.Spring.Transactional;

import com.shijing.nopainnogain.Spring.annotation.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @Auther: shijing
 * @Date: 19/7/3 16:39
 * @Description: SystemConfigService
 */
@Service
public class SystemConfigService {
    @Autowired
    private SystemConfigDao systemConfigDao;

    @PersistenceContext
    private EntityManager entityManager;

    public String getOriginalVersion() {
        SystemConfig config = systemConfigDao.findByScode("version");
        //设置初始版本号v1.0，后面升级的版本号必须大于v1.0
        if (config == null)
            config = addConfig("版本号", "version", "v1.0", "");
        return config.getSstatus();
    }

    @Master
    @Transactional
    public SystemConfig addConfig(String name, String code, String status, String describe) {
        SystemConfig config = new SystemConfig(name, code, status, describe);
        return systemConfigDao.save(config);
    }

    public SystemConfig getConfig(String code) {
        return systemConfigDao.findByScode(code);
    }

    public int save(String version) {
        SystemConfig config = systemConfigDao.findByScode("version");
        config.setSstatus(version);
        systemConfigDao.save(config);
        return config.getId();
    }

    @Transactional
    @Modifying
    public boolean dropIndex(String table, String indexName) throws Exception{
        Query query = entityManager.createNativeQuery("DROP INDEX " + indexName + " ON " + table);
        query.executeUpdate();
        return true;
    }

    @Transactional
    @Modifying
    public boolean createIndex(String table, String indexName, String columnName) throws Exception{
        Query query = entityManager.createNativeQuery("CREATE INDEX " + indexName + " ON " + table + "("+columnName+")" );
        query.executeUpdate();
        return true;
    }
}
