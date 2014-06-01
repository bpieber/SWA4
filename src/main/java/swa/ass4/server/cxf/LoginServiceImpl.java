package swa.ass4.server.cxf;

import java.util.HashMap;
import java.util.Map;

@javax.jws.WebService(endpointInterface = "swa.ass4.server.cxf.LoginService")
public class LoginServiceImpl implements LoginService {

	Map<String, User> users;

	public LoginServiceImpl() {
		users = new HashMap<String, User>();
		users.put("admin", new User("admin", "password", "Administrator"));
	}

	@Override
	public User login(String userName, String password) {
		User user = users.get(userName);
		if (user == null || !user.verifyPassword(password)) {
			return null;
		}
		return user;
	}
}