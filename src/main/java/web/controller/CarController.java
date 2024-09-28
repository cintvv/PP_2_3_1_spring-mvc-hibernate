package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.carDao.CarDAO;


@Controller
public class CarController {

    private final CarDAO carDAO;

    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping(value = {"/cars", "/cars?count={}" })
    public String printWelcome(ModelMap model, @RequestParam(required = false) Integer count) {
        if (count == null || count == 0 || count > carDAO.countCars()) {
            model.addAttribute("cars", carDAO.getCars());
        } else {
            model.addAttribute("cars", carDAO.getCars().subList(0, count));
        }
        return "cars";
    }
}
