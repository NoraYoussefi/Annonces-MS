package fstt.lsi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "AUTH-SERVICE")
public interface userFeign {

	@GetMapping(value = "/connexion/getid")
	String getUserId(@RequestHeader(value = "Authorization", required = true) String authorizationHeader);
}
