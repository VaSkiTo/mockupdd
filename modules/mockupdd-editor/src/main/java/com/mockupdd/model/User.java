package com.mockupdd.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.mockupdd.security.UserRole;

public class User extends Entity<Long>{
	
	private List<Project> projects;
	private String displayName;

	public User(){
		this.projects = new ArrayList<Project>();
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public void addProject(Project project){
		this.projects.add(project);
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(UserRole.ROLE_USER.getAuthority());
		return authorities;
	}

}
