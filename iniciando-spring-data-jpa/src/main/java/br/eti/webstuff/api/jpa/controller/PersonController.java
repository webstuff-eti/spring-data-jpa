package br.eti.webstuff.api.jpa.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.eti.webstuff.api.jpa.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PersonController {

	@Autowired
	private PersonService personService;

}
