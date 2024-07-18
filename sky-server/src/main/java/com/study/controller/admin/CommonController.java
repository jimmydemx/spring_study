package com.study.controller.admin;


import com.study.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/common")
@Api(tags="通用接口")
public class CommonController {

    @PostMapping("/upload")

    public Result<String> upload(MultipartFile file){


        return null;
    }
}
