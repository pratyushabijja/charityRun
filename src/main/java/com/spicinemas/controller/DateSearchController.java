package com.spicinemas.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spicinemas.model.Screen;
import com.spicinemas.model.ShowTime;
import com.spicinemas.model.searchresult.DateSearchResult;
import com.spicinemas.repository.ScreenRepository;
import com.spicinemas.repository.ShowTimeRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DateSearchController implements BaseController {

	@Autowired
	ShowTimeRepository showTimeRepo;
	
	@Autowired
	ScreenRepository screenRepository;

	@GetMapping(value = "/search/date", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> searchMoviesByDate(@RequestParam String date, @RequestParam String movieId) {

		DateSearchResult dateSearchResult = new DateSearchResult();
		dateSearchResult.setDate(date);

		HashMap<String, HashSet<HashMap<String, HashSet<String>>>> hm = new HashMap<>();

		for (ShowTime showTime : showTimeRepo.findByDateAndMovieId(date, movieId)) {

			String tId = showTime.getTheatreId();
			String scId = showTime.getScreenId();
			String sl = showTime.getSlots();
			Screen s = screenRepository.findByUid(scId);
			ArrayList<ArrayList<Integer>> seatLayout = s.getSeat_layout();
			System.out.println(seatLayout+"name"+s.getName());
			if (hm.containsKey(tId)) {

				HashSet<HashMap<String, HashSet<String>>> hs3 = new HashSet<HashMap<String, HashSet<String>>>();
				for (HashMap<String, HashSet<String>> hmInternal : hm.get(tId)) {
					if (hmInternal.containsKey(scId)) {
						if (hmInternal.get(scId) == null) {
							hmInternal.put(scId, new HashSet<String>() {
								{
									add(sl);
								}
							});
						} else {
							hmInternal.get(scId).add(sl);
						}
					} else {
						HashSet<String> hs1 = new HashSet<String>() {
							{
								add(sl);
							}
						};

						HashMap<String, HashSet<String>> hs2 = new HashMap<String, HashSet<String>>() {
							{
								put(scId, hs1);
							}
						};

						hs3.add(hs2);
					}
				}
			} else {
				HashSet<String> hs1 = new HashSet<String>() {
					{
						add(sl);
					}
				};

				HashMap<String, HashSet<String>> hs2 = new HashMap<String, HashSet<String>>() {
					{
						put(scId, hs1);
					}
				};

				HashSet<HashMap<String, HashSet<String>>> hs3 = new HashSet<HashMap<String, HashSet<String>>>() {
					{
						add(hs2);
					}
				};

				hm.put(tId, hs3);

			}

		}

		dateSearchResult.setTheatre(hm);

		return new ResponseEntity<Object>(dateSearchResult,
				HttpStatus.ACCEPTED);
	}

}
