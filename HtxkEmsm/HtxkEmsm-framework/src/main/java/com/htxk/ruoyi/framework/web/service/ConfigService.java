package com.htxk.ruoyi.framework.web.service;

import com.htxk.ruoyi.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RuoYi首创 html调用 thymeleaf 实现参数管理
 *
 * @author ruoyi
 */
@Service("config")
public class ConfigService {
    @Autowired
    private ISysConfigService configService;

    /**
     * 根据键名查询参数配置信息
     *
     * @param configName 参数名称
     * @return 参数键值
     */
    public String getKey(String configKey) {
        return configService.selectConfigByKey(configKey);
    }
}
