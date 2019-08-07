package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

  @Autowired
  DistilleryRepository distilleryRepository;

  @GetMapping(value = "/located/{region}")
  public List<Distillery> findDistilleriesByRegion(@PathVariable String region) {
    String[] regionArray = region.toLowerCase().split(" ");
    String[] namesCapitalized = new String[regionArray.length];
    for(int i = 0; i < regionArray.length; i++) {
      String firstLetter = regionArray[i].substring(0, 1).toUpperCase();
      namesCapitalized[i] = firstLetter + regionArray[i].substring(1);
    }
    String formattedRegion = String.join(" ", namesCapitalized);
    return distilleryRepository.findDistilleriesByRegion(formattedRegion);
  }
}
