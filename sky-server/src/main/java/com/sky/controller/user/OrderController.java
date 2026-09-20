package com.sky.controller.user;

import com.sky.dto.OrdersPageQueryDTO;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("userOrderController")
@RequestMapping("/user/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/submit")
    public Result<OrderSubmitVO> submit(@RequestBody OrdersSubmitDTO ordersSubmitDTO) {
        return Result.success(orderService.submit(ordersSubmitDTO));
    }

    @GetMapping("/historyOrders")
    public Result<PageResult> page(int page,int pageSize,Integer status){
        return Result.success(orderService.pageQuery4User(page,pageSize,status));
    }

    @GetMapping("/{id}")
    public Result<OrderVO> details(@PathVariable("id") Long id){
        return Result.success(orderService.details(id));
    }

    @PutMapping("/{id}")
    public Result cancel(@PathVariable("id")Long id)throws Exception{
        orderService.userCancelById(id);
        return Result.success();
    }


    @PostMapping("/repetition/{id}")
    public Result repetition(@PathVariable("id")Long id){
        orderService.repetition(id);
        return Result.success();
    }

    @GetMapping("/reminder/{id}")
    public Result reminder(@PathVariable("id")Long id){
        orderService.reminder(id);
        return Result.success();
    }
}
