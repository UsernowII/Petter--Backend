package com.web.petter.service.api;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void process(MultipartFile file);

}
