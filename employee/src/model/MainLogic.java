package model;

import java.util.List;

import dao.MainDAO;

public class MainLogic {
	public List<Account> execute() {
		MainDAO dao = new MainDAO();
		List<Account> account = dao.findAll();
		return (List<Account>) account;
	}
}
