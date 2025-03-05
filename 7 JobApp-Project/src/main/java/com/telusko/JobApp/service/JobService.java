package com.telusko.JobApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.JobApp.model.JobPost;
import com.telusko.JobApp.repo.JobRepo;

@Service
public class JobService {
	@Autowired
	public JobRepo repo;
	
	
	
	//method to return all JobPosts
	public List<JobPost> returnAllJobPosts() {
		return repo.findAll();

		
	}

	public Optional<JobPost> getJob(int postId) {
		return repo.findById(postId);


	}
	
	
	
	

	// ***************************************************************************


	
	
	
	// method to add a jobPost
	public JobPost addJobPost(JobPost jobPost) {
		 return repo.save(jobPost);
	
	}
	public List<JobPost> findJobByKeyWord(String Keyword){
		return repo.findByPostProfileContainingOrPostDescContaining(Keyword,Keyword);
	}
	public void deleteJobById(Integer id){
		repo.deleteById(id);
	}

	public JobPost updateJob(JobPost jb){
		return repo.save(jb);
	}
	public Optional<JobPost> findById(Integer id){
		return repo.findById(id);
	}


	
}
