package com.codeclan.example.WhiskyTracker.controllers;

import antlr.StringUtils;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

  @Autowired
  WhiskyRepository whiskyRepository;

  @GetMapping(value = "/bottled/{year}")
  public List<Whisky> findWhiskiesByYear(@PathVariable int year) {
    return whiskyRepository.findWhiskiesByYear(year);
  }

  @GetMapping(value = "/from/{distillery}/aged/{age}")
  public List<Whisky> findWhiskiesFromDistilleryThatHaveAge(@PathVariable String distillery, @PathVariable int age) {
    String[] nameArray = distillery.toLowerCase().split(" ");
    String[] namesCapitalized = new String[nameArray.length];
    for(int i = 0; i < nameArray.length; i++) {
      String firstLetter = nameArray[i].substring(0, 1).toUpperCase();
      namesCapitalized[i] = firstLetter + nameArray[i].substring(1);
    }
    String formattedName = String.join(" ", namesCapitalized);
    return whiskyRepository.findWhiskiesFromDistilleryThatHaveAge(formattedName, age);
  }
}
