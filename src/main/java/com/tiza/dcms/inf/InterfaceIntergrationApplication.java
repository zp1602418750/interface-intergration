package com.tiza.dcms.inf;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfigurationPackage
@NacosPropertySource(
		groupId = "DEFAULT_GROUP",
		dataId = "report-center",
		autoRefreshed = true,
		type = ConfigType.PROPERTIES
)
public class InterfaceIntergrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterfaceIntergrationApplication.class, args);
	}
	
}
