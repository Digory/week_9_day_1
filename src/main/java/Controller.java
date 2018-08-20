import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.get;

public class Controller {

    public static void main(String[] args) {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        HashMap<String, Object> model = new HashMap<>();
        model.put("cohort", Cohort.class);

        get("/random", (req, res) -> {
            return new ModelAndView(model, "one.vtl");
        }, velocityTemplateEngine);

        get("/pair", (req, res) -> {
            return new ModelAndView(model, "pair.vtl");
        }, velocityTemplateEngine);

        get("/pairs", (req, res) -> {
            HashMap<String, ArrayList<Student>> allPairs = Cohort.getAllPairs();
            return new ModelAndView(allPairs, "pairs.vtl");
        }, velocityTemplateEngine);

        get("/group/:size", (req, res) -> {
            int groupSize = Integer.parseInt(req.params(":size"));
            HashMap<String, Object> groupModel = new HashMap<>();
            groupModel.put("cohortGroup", Cohort.getGroupOfThisSize(groupSize));
            return new ModelAndView(groupModel, "group.vtl");
        }, velocityTemplateEngine);

        get("/groups/:size", (req, res) -> {
            int groupSize = Integer.parseInt(req.params(":size"));
            HashMap<String, Object> groupModel = Cohort.getAllGroupsOfThisSize(groupSize);
            return new ModelAndView(groupModel, "groups.vtl");
        }, velocityTemplateEngine);


    }
}
