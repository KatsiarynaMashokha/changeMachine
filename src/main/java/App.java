import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;


/**
 * Created by Guest on 8/7/17.
 */
public class App {
    public static void main(String[] args) {

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/total_change", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Float totalAmount = Float.parseFloat(request.queryParams("change"));
            ChangeMachine machine = new ChangeMachine();
            String changeText = machine.makeChange(totalAmount);
            model.put("changeTextShow", changeText);
            return new ModelAndView(model, "total_change.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
