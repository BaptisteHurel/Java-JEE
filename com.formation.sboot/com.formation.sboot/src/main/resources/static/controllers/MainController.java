package controllers;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.*;

@RequestMapping({"","/"})
public class MainController {
@GetMapping
	public String starter() {
		return "Server Stated... "+LocalDateTime.now();
	}

}
