package com.sky.controller.admin;

import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公共接口
 */
@RestController
@RequestMapping("/admin/common")
@Slf4j
public class CommonController {

//    @Autowired
//    private AliOssUtil aliOssUtil;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){
            return Result.success("111.jpg");
//        try {
//            String originalFilename = file.getOriginalFilename();
//            originalFilename.substring(originalFilename.lastIndexOf("."));
//            String objectName = UUID.randomUUID().toString() + originalFilename;
//            String url = aliOssUtil.upload(file.getBytes(), objectName);
//            return Result.success(url);
//        }catch (IOException e){
//            log.error("上传文件失败",e);
//            return Result.error("上传文件失败");
//        }
    }
}
