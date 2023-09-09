package cn.icodening.cloud.example.kubernetes.provider.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.icodening.cloud.example.kubernetes.provider.config.ProviderProperties;

@RequestMapping
@RestController
public class ProviderController {

    @Autowired
    private InetUtilsProperties inetUtilsProperties;

    @Autowired
    private Environment environment;

    @Autowired
    private ProviderProperties providerProperties;

    @GetMapping("/echo")
    public Map<String, Object> echoMetadata() {
        var result = new LinkedHashMap<String, Object>(16);
        result.put("host", inetUtilsProperties.getDefaultHostname());
        return result;
    }

    @GetMapping("/env/{key}")
    public String getEnv(@PathVariable String key) {
        return environment.getProperty(key);
    }

    @GetMapping("/envs")
    public Map<String, Object> getSystemEnvs() {
        var result = new HashMap<String, Object>();
        result.put("system", System.getenv());
        result.put("properties", System.getProperties());
        return result;
    }

    @GetMapping("/prop")
    public ProviderProperties getProp() {
        return providerProperties;
    }

}
