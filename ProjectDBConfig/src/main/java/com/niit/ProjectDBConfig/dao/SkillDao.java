package com.niit.ProjectDBConfig.dao;

import java.util.List;

import com.niit.ProjectDBConfig.modal.Skill;


public interface SkillDao {

	public boolean add(Skill skill);

	public boolean deleteSkill(int employeeid);

	public boolean update(Skill employee);

	public Skill getUpdateId(int employeeid);

	public Skill getEmployeebyId(int employeeid);

	List<Skill> getAllSkills();// view list of all record

	List<Skill> SearchSkills(String skillType);
}
