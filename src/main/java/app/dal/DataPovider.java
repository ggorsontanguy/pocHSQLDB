package app.dal;

import java.util.List;

import app.dal.entities.Users;

public interface DataPovider {
	String loadData();
	List<Users> getUsers();
}
