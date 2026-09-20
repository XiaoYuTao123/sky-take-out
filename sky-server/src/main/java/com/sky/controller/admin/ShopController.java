package com.sky.controller.admin;

import com.sky.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@RequestMapping("/admin/shop")
public class ShopController {

    public static final String KEY="SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    @PutMapping("/{status}")
    public Result updateShopStatus(@PathVariable Integer status) {
        redisTemplate.opsForValue().set(KEY, status.toString());
        return Result.success();
    }

    @GetMapping("/status")
    public Result getShopStatus() {
        String status = redisTemplate.opsForValue().get(KEY).toString();
        return Result.success(status);
    }
}
