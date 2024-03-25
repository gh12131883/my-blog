package com.m.blog.global.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class FileProperties {
    @Value("${file.directory:#{null}}") private String directoryName;
    @Value("${file.isLocal:#{null}}") private boolean isLocal;
}
