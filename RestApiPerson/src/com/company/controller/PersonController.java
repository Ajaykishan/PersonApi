package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.company.entity.Person;
import com.company.exception.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.company.persistence.PersonDaoImplement;

@Controller
public class PersonController {

	String process;

	@RequestMapping(value = "/RegisterPerson", method = RequestMethod.GET)
	public ModelAndView getRegistrationForm() {
		ModelAndView model = new ModelAndView("PersonRegistrationForm");
		return model;
	}

	@RequestMapping(value = "/RegistrationSuccess", method = RequestMethod.POST)
	public ModelAndView submitRegistrationForm(
			@Valid @ModelAttribute("personObject") Person person,
			BindingResult result) {

		PersonDaoImplement personObj = new PersonDaoImplement();
		if (result.hasErrors()) {

			ModelAndView model = new ModelAndView("PersonRegistrationForm");
			return model;
		}
		personObj.save(person);
		ModelAndView model = new ModelAndView("RegistrationSuccess");
		model.addObject(person);
		return model;

	}

	@RequestMapping(value = "/ViewPerson/{personID}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	ModelAndView RetrieveById(@PathVariable("personID") int id) throws CustomException {

		PersonDaoImplement personObj = new PersonDaoImplement();
		Person personObject = personObj.retrieveById(id);
		ModelAndView model = new ModelAndView("DisplayResults");
		if (personObject != null) {
			process = "Retrieved Records:";
			model.addObject("resultObject", personObject);
		} else {
			 throw new CustomException(204, "Requested Id is not available");
		}
		model.addObject("process", process);
		return model;

	}
	
	@RequestMapping(value = "/DeletePerson/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteById(@PathVariable("id") int id) throws CustomException {
		PersonDaoImplement personObj = new PersonDaoImplement();
		Person personObject = personObj.deleteById(id);
		ModelAndView model = new ModelAndView("DisplayResults");
		if (personObject != null) {
			process = "Deleted Records:";
			model.addObject("resultObject", personObject);
		} else {
			 throw new CustomException(204, "Requested Id is not available");
  	}
		model.addObject("process", process);
		return model;

	}


	@RequestMapping(value = "/ViewPersons", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<Person> ViewPersons() {

		PersonDaoImplement personObj = new PersonDaoImplement();
		List<Person> personList = new ArrayList<Person>();
		personList = personObj.retrieveAll();
		return personList;

	}

	@RequestMapping(value = "/UpdatePerson", method = RequestMethod.PUT)
	public ModelAndView updatePersonById(
			@Valid @ModelAttribute("personObject") Person person,
			BindingResult result) throws CustomException {

		ModelAndView model = new ModelAndView("DisplayResults");
		PersonDaoImplement personObj = new PersonDaoImplement();
		if ((person.getPersonCity() == null) || (person.getPersonId() == 0)
				|| (person.getPersonName() == null)
				|| (person.getEmailID() == null)
				|| (person.getPersonState() == null)
				|| (person.getContactNumber() == null)) {
			 throw new CustomException(400 , "Kindly enter all attributes of person. Bad Request !");
		} else {
			Person personObject = personObj.updateById(person.getPersonId(),
					person);

			if (personObject != null) {
				process = "Updated Records:";
				model.addObject("resultObject", personObject);
			} else {
				 throw new CustomException(204, "Requested Id is not available");
			}
			model.addObject("process", process);
			return model;
		}
	}
	
	


	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = CustomException.class)
	public ModelAndView HandleCustomException(CustomException err) {
		ModelAndView model = new ModelAndView("Exception");
		model.addObject("error",err);
		return model;
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public ModelAndView HandleException(Exception err)  {
	
		CustomException obj = new CustomException(500 , "Unknown Error");
		ModelAndView model = new ModelAndView("Exception");
		model.addObject("error",obj);
		return model;
	}
	

}
