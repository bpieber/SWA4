package swa.ass4.server.cxf;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface LoginService {
	public User login(@WebParam(name = "userName") String userName,
			@WebParam(name = "password") String password);
}