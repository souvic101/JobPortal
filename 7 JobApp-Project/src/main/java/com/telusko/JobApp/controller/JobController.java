package com.telusko.JobApp.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.telusko.JobApp.model.JobPost;
import com.telusko.JobApp.service.JobService;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

	@Autowired
	private JobService service;
	// ************************************************************************

	@RequestMapping({"/","/home"})
	public String home() {
		return "home";
	}

	// ************************************************************************

	@RequestMapping("/addjob")
	public String addJob() {
		return "addjob";
	}

	// ************************************************************************

	// controller method for getting all job posts
	@GetMapping("/viewalljobs")
	public List<JobPost> viewJobs() {

		//List<JobPost> jobPosts = service.returnAllJobPosts();
		//model.addAttribute("jobPosts", jobPosts);
		return service.returnAllJobPosts();
	}
	@GetMapping("jobPost/{id}")
	public Optional<JobPost> getJobById(@PathVariable Integer id){
		return service.findById(id);
	}
	
	// ************************************************************************

	@PostMapping("/handleForm")
	public JobPost handleAddJobForm( @RequestBody JobPost jobPost) {
		//model.addAttribute("jobPost", jobPost);
		return service.addJobPost(jobPost);
		//System.out.println(jobPost);
		  //return "success";
		
	}
	@GetMapping("jobPosts/Keyword/{keyword}")
	public List<JobPost> findByKeyWord(@PathVariable String keyword){
		return service.findJobByKeyWord(keyword);
	}

	@DeleteMapping("jobPost/{jobId}")
	public void deleteJob(@PathVariable Integer jobId){
		service.deleteJobById(jobId);
	}
	@PutMapping("/jobPost")
	public Optional<JobPost> updateJobProfile(@RequestBody JobPost jb){
	 service.updateJob(jb);
	 return  service.findById(jb.getPostId());


	}
	


	
	
	
	
	
	
	
	
	
	
}
