package com.codeclan.example.WhiskyTracker.controllers;

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

  @GetMapping(value = "/released/{year}")
  public List<Whisky> findWhiskiesByYear(@PathVariable int year) {
    return whiskyRepository.findWhiskiesByYear(year);
  }

  @GetMapping(value = "/distillery/id/{distilleryId}/aged/{age}")
  public List<Whisky> findWhiskiesFromDistilleryIdAndAged(@PathVariable Long distilleryId, @PathVariable int age) {
    return whiskyRepository.findWhiskiesFromDistilleryAndAged(distilleryId, age);
  }

  @GetMapping(value = "/distillery/named/{distillery}/aged/{age}")
  public List<Whisky> findWhiskiesFromDistilleryNameAndAged(@PathVariable String distillery, @PathVariable int age) {
    return whiskyRepository.findWhiskiesFromDistilleryAndAged(distillery, age);
  }

  @GetMapping(value = "/from/{region}")
  public List<Whisky> findWhiskiesByRegion(@PathVariable String region) {
    return whiskyRepository.findWhiskiesByRegion(region);
  }
}
