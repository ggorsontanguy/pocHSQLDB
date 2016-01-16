package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dal.DataPovider;
import app.dal.entities.Users;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private DataPovider dataProvider;

	@Override
	public String getValue() {

		List<Users> users = dataProvider.getUsers();

		StringBuilder sb = new StringBuilder();
		for (Users u : users) {
			sb.append(String.format("ID=%s, FirstName=%s, LastName=%s\n", u.getId(),
					u.getFirstName(), u.getLastName()));
		}

		// perform business operation(s) with data

		return sb.toString();
	}
}
