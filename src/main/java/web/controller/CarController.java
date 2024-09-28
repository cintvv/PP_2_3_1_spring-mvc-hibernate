package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.carDao.CarDAO;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.List;


@Controller
public class CarController {

    private final CarDAO carDAO;

    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping(value = {"/cars", "/cars?count={}" })
    public String printWelcome(ModelMap model, @RequestParam(required = false) Integer count) {
        CarServiceImpl carService = new CarServiceImpl();
        if (count != null) {
            model.addAttribute("cars", carService.count(carDAO.getCars(), count));
        } else {
            model.addAttribute("cars", carService.count(carDAO.getCars(), carDAO.getCars().size()));
        }
        return "cars";
    }
}
