package com.kgisl.nsedata.controller;

import java.util.*;
import com.kgisl.nsedata.*;
import com.kgisl.nsedata.model.NseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import io.swagger.models.Model;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class NseController {


	@RequestMapping(value = "/{category}", method = {RequestMethod.GET})
	public @ResponseBody String showUserTable(@RequestParam("category") String category) {
		String nseDatas;
			RestTemplate restTemplate = new RestTemplate();
	// @RequestMapping(value = { "showNseData" }, method = { RequestMethod.GET })
	// public @ResponseBody String showUserTable(@RequestParam("category") String category) {
	// 	String nseDatas;
	// 	RestTemplate restTemplate = new RestTemplate();
		if (category == null) {
			nseDatas = restTemplate.getForObject(
					"https://www.nseindia.com/live_market/dynaContent/live_watch/stock_watch/niftyStockWatch.json",
					String.class); // or however I use restTemplates, havent done it yet so still fuzzy but
									// shouldnt be too tricky.
		} 
		else {

			nseDatas = restTemplate
					.getForObject("https://www.nseindia.com/live_market/dynaContent/live_watch/stock_watch/" + category
							+ "StockWatch.json", String.class); // or however I use restTemplates, havent done it yet so														// // still fuzzy but shouldnt be too tricky.
		}
		return nseDatas;
	}

	// public @ResponseBody String showUserTable(@RequestBody String category) {
	// 	System.out.println("++++++++++++++"+category);
	// 		return null;
	// }

}
