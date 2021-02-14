package com.example.demo.controllers.ipo;

import com.example.demo.dto.IpoDetailsDto;
import com.example.demo.services.IPOService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created By : arshia on 03/02/21
 **/
@RestController
@RequestMapping("/ipo")
public class IPOController {

    @Autowired
    private IPOService ipoService;

    @ApiOperation("Create New IPO")
    @PostMapping(value = "")
    public String createNewIPO(@RequestBody IpoDetailsDto ipoDetailsDto) {
        return ipoService.createNewIPODetails(ipoDetailsDto);
    }

    @ApiOperation("Get Available IPO Details")
    @GetMapping(value = "")
    public List<IpoDetailsDto> getIpoDetails() {
        return ipoService.getIPODetails();
    }
}
