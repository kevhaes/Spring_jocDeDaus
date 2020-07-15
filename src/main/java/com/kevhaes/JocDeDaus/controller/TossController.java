/**
 * @author KevHaes
 *
 */
package com.kevhaes.JocDeDaus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevhaes.JocDeDaus.dto.Toss;
import com.kevhaes.JocDeDaus.service.TossService;

/**
 * @author KevHaes
 *
 */
@RestController
@RequestMapping(path = "/api/tosses")
public class TossController {

	/////////////// ATRIBUTES ///////////////
	@Autowired
	TossService tossService;

	/////////////// METHODS ///////////////
	@PostMapping
	public Toss createToss() {
		return tossService.createToss();
	}

}
