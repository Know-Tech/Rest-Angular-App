package com.niit.ProjectDBConfig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.ProjectDBConfig.dao.SkillDao;
import com.niit.ProjectDBConfig.modal.Skill;

@Service
public class SkillSerivceImpls implements SkillService {

	@Autowired
	private SkillDao skillDAO;

	public boolean add(Skill skill) {
		return skillDAO.add(skill);
	}

	public boolean delete(int employeeid) {

		return (skillDAO.deleteSkill(employeeid));

	}

	public boolean update(Skill employee) {
		// TODO Auto-generated method stub
		return skillDAO.update(employee);
	}

	public Skill getUpdateId(int employeeid) {
		return (skillDAO.getUpdateId(employeeid));

	}

	public List<Skill> getAllSkills() {
		return skillDAO.getAllSkills();
	}

	public List<Skill> SearchSkills(String skillType) {
		return skillDAO.SearchSkills(skillType);
	}

	public Skill getEmployeebyId(int employeeid) {
		return (skillDAO.getEmployeebyId(employeeid));
	}

}
