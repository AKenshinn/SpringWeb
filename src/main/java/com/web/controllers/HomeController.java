package com.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Kenshinn on 1/3/2016 AD.
 */
@Controller
public class HomeController {

  private static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

  @RequestMapping(value = "/home", method = {RequestMethod.GET})
  public String home() {
    LOGGER.info("Mapping: /home");
    return "home";
  }

}
