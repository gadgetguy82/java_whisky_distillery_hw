package com.codeclan.example.WhiskyTracker.models.projections;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedWhiskies", types = Distillery.class)
public interface EmbedWhiskies {
  String getName();
  String getRegion();
  List<Whisky> getWhiskies();
}
