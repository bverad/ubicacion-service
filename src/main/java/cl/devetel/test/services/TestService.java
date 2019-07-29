package cl.devetel.test.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TestService {
	
	public String greeting() {
		return "Un saludo desde session service";
	}
	
}
