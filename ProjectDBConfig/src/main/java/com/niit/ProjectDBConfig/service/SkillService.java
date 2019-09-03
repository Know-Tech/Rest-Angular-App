package com.niit.ProjectDBConfig.service;

import java.util.List;

import com.niit.ProjectDBConfig.modal.Skill;

public interface SkillService {

	public boolean add(Skill skill);

	public boolean delete(int employeeid);

	public boolean update(Skill employee);

	public Skill getUpdateId(int employeeid);

	List<Skill> getAllSkills();// view all records

	public Skill getEmployeebyId(int employeeid);

	List<Skill> SearchSkills(String skillType);
}
