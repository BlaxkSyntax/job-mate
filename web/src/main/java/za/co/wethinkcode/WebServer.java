package za.co.wethinkcode;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.rendering.template.JavalinThymeleaf;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import za.co.wethinkcode.app.DefaultAccessManager;
import za.co.wethinkcode.app.Sessions;
import za.co.wethinkcode.app.controllers.about.AboutController;
import za.co.wethinkcode.app.controllers.community.CommunityController;
import za.co.wethinkcode.app.controllers.contact.ContactController;
import za.co.wethinkcode.app.controllers.home.HomeController;
import za.co.wethinkcode.app.controllers.jobe.JobsController;
import za.co.wethinkcode.app.controllers.preparation.PrepController;
import za.co.wethinkcode.app.controllers.pricing.PricingController;
import za.co.wethinkcode.app.controllers.register.RegisterController;
import za.co.wethinkcode.app.controllers.resume.ResumeController;
import za.co.wethinkcode.app.controllers.servicess.ServicesController;
import za.co.wethinkcode.app.controllers.signing.SigningController;

import org.jetbrains.annotations.NotNull;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import static io.javalin.apibuilder.ApiBuilder.*;

public class WebServer {
    private static final int DEFAULT_PORT = 5000;
    private final String STATIC_DIR = "/html";
    private final Javalin app;

    /**
     * The main class starts the server on the default port 7070.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        WebServer server = new WebServer();
        server.start(DEFAULT_PORT);
    }

    //public static Javalin getInstance(){
        //new HiddinLeaf();
        //Javalin server = createAndConfigureServer();
        //setupRoutes(server);
        //return server;
    //}

    public WebServer() {
        configureThymeleafTemplateEngine();
        app = createAndConfigureServer();
        setupRoutes(app);
    }

    public void start(int port) {
       app.start(port);
    }

    public int port() {
        return app.port();
    }

    public void close() {
        app.close();
    }

    /**
     * Setup the Thymeleaf template engine to load templates from 'resources/templates'
     */
    private void configureThymeleafTemplateEngine() {
        TemplateEngine templateEngine = new TemplateEngine();

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");
        templateEngine.setTemplateResolver(templateResolver);

        templateEngine.addDialect(new LayoutDialect());
        JavalinThymeleaf.configure(templateEngine);
    }

    private void setupRoutes(Javalin server) {
        server.routes(() -> {
            homePageRoute();
            resumePageRoutes();
            jobPageRoute();
            prepPageRoutes();
            communityPageRoute();
            servicesPageRoutes();
            pricingPageRoute();
            aboutPageRoutes();
            contactPageRoute();
            signingRoutes();
            registerRoutes();
        });
    }

    private void homePageRoute() {
        get(HomeController.getPath(), HomeController::renderHomePage);
    }

    private void resumePageRoutes() {
        get(ResumeController.getPath(), ResumeController::renderResumePage);
    }

    private void jobPageRoute() {
        get(JobsController.getPath(), JobsController::renderjobsPage);
        post(JobsController.getAddJobPath(), JobsController::handleAddJobPage);
        get(JobsController.getAddJobPagePath(), JobsController::renderaddjobsPage);
    }

    private void prepPageRoutes() {
        get(PrepController.getPath(), PrepController::renderPrepPage);
    }

    private void communityPageRoute() {
        get(CommunityController.getPath(), CommunityController::renderCommunityPage);
    }

    private void servicesPageRoutes() {
        get(ServicesController.getPath(), ServicesController::renderServicesPage);
    }

    private void pricingPageRoute() {
        get(PricingController.getPath(), PricingController::renderPricingPage);
    }

    private void aboutPageRoutes() {
        get(AboutController.getPath(), AboutController::renderAboutPage);
    }

    private void contactPageRoute() {
        get(ContactController.getPath(), ContactController::renderContactPage);
    }

    private void signingRoutes() {
        post(SigningController.getSigninPath(), SigningController::handlesignin);
        post(SigningController.SIGNOUT_PATH, SigningController::handleSignout);
    }

    private void registerRoutes(){
        get(RegisterController.getUserPath(), RegisterController::renderRegisterPage);
        post(RegisterController.getPath(), RegisterController::handleRegister);
    }
    
    @NotNull
    private Javalin createAndConfigureServer() {
        return Javalin.create(config -> {
            config.enableDevLogging();
            config.addStaticFiles(staticFiles -> {
                staticFiles.directory = this.STATIC_DIR;
                staticFiles.location = Location.CLASSPATH;
            });
            // config.addStaticFiles(STATIC_DIR, Location.CLASSPATH);
            //config.sessionHandler(Sessions::nopersistSessionHandler);
            //config.accessManager(new DefaultAccessManager());
        });
    }
}