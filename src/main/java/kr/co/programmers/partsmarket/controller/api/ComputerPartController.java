package kr.co.programmers.partsmarket.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.programmers.partsmarket.model.ComputerPart;
import kr.co.programmers.partsmarket.service.ComputerPartService;

@RestController
public class ComputerPartController {

	private ComputerPartService computerPartService;

	public ComputerPartController(ComputerPartService computerPartService) {
		this.computerPartService = computerPartService;
	}

	@GetMapping("/api/computer-parts")
	public List<ComputerPart> computerPartList() {
		return computerPartService.getAllComputerParts();
	}
}
