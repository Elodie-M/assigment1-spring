/*
 * Student ID: 991792021
 * Full Name: Elodie Mesiha
 * Course: PROG27545
 * Assignment: 1 - Pizza Ordering App
 */
package com.example.Assigment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
         return "redirect:/order";
    }
}
