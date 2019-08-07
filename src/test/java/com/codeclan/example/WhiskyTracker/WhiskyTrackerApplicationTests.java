package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskiesByYear() {
		List<Whisky> found = whiskyRepository.findWhiskiesByYear(2018);
		assertEquals(new Long(1), found.get(0).getId());
	}

	@Test
	public void canFindDistilleriesByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Lowland");
		assertEquals(new Long(2), found.get(0).getId());
	}

	@Test
	public void canFindWhiskiesByDistilleryAndAge() {
		List<Whisky> found = whiskyRepository.findWhiskiesFromDistilleryThatHaveAge("Glendronach", 15);
		assertEquals(new Long(1), found.get(0).getId());
	}

	@Test
	public void canFindWhiskiesByRegion() {
		List<Whisky> found = whiskyRepository.findWhiskiesByRegion("Highland");
		assertEquals(new Long(1), found.get(0).getId());
	}

	@Test
	public void canFindDistilleriesWithWhiskiesAged() {
		List<Distillery> found = distilleryRepository.findDistilleriesThatHaveWhiskiesAged(12);
		assertEquals(new Long(2), found.get(0).getId());
	}
}
