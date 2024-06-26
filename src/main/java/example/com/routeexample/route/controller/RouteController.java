package example.com.routeexample.route.controller;

import example.com.routeexample.route.dto.RouteGetResDto;
import example.com.routeexample.route.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/routes")
public class RouteController {
    private final RouteService routeService;

    @GetMapping()
    public String findRoute(Model model, @RequestParam String startBuilding, @RequestParam String startRoom,
        @RequestParam String  endBuilding, @RequestParam String endRoom) {
        RouteGetResDto routeGetResDto = routeService.findRoute(startBuilding, startRoom, endBuilding, endRoom);
        model.addAttribute("routeInfo", routeGetResDto);
        return "index";
    }
}
