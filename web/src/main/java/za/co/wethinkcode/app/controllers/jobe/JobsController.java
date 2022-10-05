package za.co.wethinkcode.app.controllers.jobe;

import io.javalin.http.Context;
import za.co.wethinkcode.app.data.Data;
import za.co.wethinkcode.app.model.AuthenticUser;
import za.co.wethinkcode.app.model.Jobs;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Controller for handling API calls for Expenses
 */
public class JobsController {
    private static final String JOB_PATH = "/jobs";
    private static final String ADD_JOB_PAGE_PATH = "/add-job";
    private static final String ADD_JOB_PATH = "/job";

    public static void renderjobsPage(Context context) throws IOException, InterruptedException{
        AuthenticUser sessionkey = context.sessionAttribute("user");

        List<Jobs> jobs = Data.INSTANCE.jobs();
        System.out.println(jobs);
        Map<String, Object> viewModel =
                Map.of("jobs", jobs);
        context.render("/jobs.html", viewModel);
    }

    public static void handleAddJobPage(Context context) throws IOException, InterruptedException{
        AuthenticUser sessionkey = context.sessionAttribute("user");
        Jobs job = new Jobs();
        
        job.setPosition(context.formParam("position"));
        job.setArea(context.formParam("area"));
        job.setJobtype(context.formParam("jobtype"));
        job.setJobDescription(context.formParam("jobDescription"));
        job.setResponsibilities(context.formParam("responsibilities"));
        job.setQualifications(context.formParam("qualifications"));
        job.setBenefits(context.formParam("benefits"));
        job.setStartDate(context.formParam("startDate"));
        job.setEndDate(context.formParam("endDate"));
        job.setApplicationtype(context.formParam("applicationtype"));
        job.setContact(context.formParam("contact"));

        String res = Data.INSTANCE.newJob(job);
        System.out.println(res.toString());

        Map<String, Object> viewModel =
                Map.of("response", res);
        context.render("/jobs.html", viewModel);
    }

    public static void renderaddjobsPage(Context context) throws IOException, InterruptedException{
        
        AuthenticUser sessionkey = context.sessionAttribute("user");
        
        Map<String, Object> viewModel =
        Map.of();
        context.render("/addjob.html", viewModel);
    }

    public static String getAddJobPagePath() {
        return ADD_JOB_PAGE_PATH;
    }

    public static String getAddJobPath() {
        return ADD_JOB_PATH;
    }

    public static String getPath() {
        return JOB_PATH;
    }
}