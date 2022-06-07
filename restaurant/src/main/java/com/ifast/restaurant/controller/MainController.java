package com.ifast.restaurant.controller;

import com.ifast.restaurant.dto.ResponseDto;
import com.ifast.restaurant.dto.RestaurantDto;
import com.ifast.restaurant.entities.Restaurant;
import com.ifast.restaurant.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@Controller
@CrossOrigin("*")
public class MainController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public ResponseEntity createRestaurant(@RequestBody RestaurantDto restaurantDto){
        Restaurant restaurant = modelMapper.map(restaurantDto,Restaurant.class);
        Restaurant savedRestaurant = restaurantService.createRestaurant(restaurant);
        return new ResponseEntity(savedRestaurant, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity getRestaurent(@PathVariable(name = "id") int id){
        Restaurant restaurant = restaurantService.getRestaurant(id);
        return new ResponseEntity(restaurant,HttpStatus.OK);
    }

    @GetMapping("/restaurants")
    public ResponseEntity getAllRestaurant(){
        return new ResponseEntity(restaurantService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/restaurant/edit/{id}")
    public ResponseEntity updateRestaurent(@RequestBody RestaurantDto restaurantDto, @PathVariable(name = "id") int id){
        Restaurant savedRestaurant = restaurantService.getRestaurant(id);
        savedRestaurant.setName(restaurantDto.getName());
        savedRestaurant.setEmail(restaurantDto.getEmail());
        savedRestaurant.setMobile(restaurantDto.getMobile());
        savedRestaurant.setAddress(restaurantDto.getAddress());
        savedRestaurant.setServices(restaurantDto.getServices());
        return new ResponseEntity(restaurantService.updateRestaurant(savedRestaurant),HttpStatus.OK);
    }

    @DeleteMapping("/restaurant/delete/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable(name = "id") int id){
        restaurantService.deleteRestaurant(id);
        ResponseDto res = new ResponseDto();
        res.setResponse("Deleted");
        return new ResponseEntity(res,HttpStatus.OK);
    }

    @GetMapping("/isRooted")
    public ResponseEntity isRooted(){
        String binaryName = "su";
        boolean found = false;
        if (!found) {
            String[] places = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/",
                    "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (String where : places) {
                if ( new File( where + binaryName ).exists() ) {
                    found = true;
                    break;
                }
            }
        }
        return new ResponseEntity(found,HttpStatus.OK);
    }

}
