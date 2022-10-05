package za.co.wethinkcode.joblist;

import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Context;
import za.co.wethinkcode.database.job.Repo;
import za.co.wethinkcode.database.model.Jobs;

public class HandleJobs {
    private final static String PATH = "/job";
    private final static String JOBS_PATH = "/jobs";

    public static void addJob(Context context) throws SQLException, JsonMappingException, JsonProcessingException{
        Jobs job = new ObjectMapper().readValue(context.body(), Jobs.class);
        String r = Repo.INSTANCE.addNewJob(job);
        context.result(r.toString());
    }

    public static void getJobs(Context context) throws SQLException, JsonMappingException, JsonProcessingException{

        List<Jobs> r = Repo.INSTANCE.jobs();
        context.result(r.toString());

    }

    public static String getJobsPath() {
        return JOBS_PATH;
    }

    public static String getPath(){
        return PATH;
    }
}