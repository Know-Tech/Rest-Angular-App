package com.niit.ProjectDBConfig.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ProjectDBConfig.modal.Skill;


@Repository("skillDAO")
@Transactional
public class SkillDaoImpls implements SkillDao {

	@Autowired
	private SessionFactory sessionFactory;
	private boolean b = true;

	public boolean add(Skill skill) {

		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(skill);
		return true;

	}

	public boolean update(Skill employee) {
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}

	public Skill getUpdateId(int employeeid) {

		return sessionFactory.getCurrentSession().get(Skill.class, employeeid);

	}

	public List<Skill> getAllSkills() {

		return (List<Skill>) sessionFactory.getCurrentSession().createCriteria(Skill.class).list();
	}

	public List<Skill> SearchSkills(String skillType) {
		return sessionFactory.getCurrentSession().createQuery("from Skill where skilltype like'%" + skillType + "%'")
				.list();
		// return sessionFact.getCurrentSession().createQuery("from Skills where
		// SKILLTYPE '"+keywords+"'").list();
	}

	public Skill getEmployeebyId(int employeeid) {
		return (Skill) sessionFactory.getCurrentSession().createQuery("from Skill where employeeid=" + employeeid)
				.uniqueResult();
		// return sessionFactory.getCurrentSession().get(Skills.class, employeeid);
	}

	public boolean deleteSkill(int employeeid) {
		Skill emp1 = getEmployeebyId(employeeid);
		if (emp1 != null) {
			sessionFactory.getCurrentSession().delete(emp1);
			return true;
		} else
			return false;

	}

}
