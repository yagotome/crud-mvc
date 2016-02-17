package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
