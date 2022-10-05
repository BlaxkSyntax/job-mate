package za.co.wethinkcode.app.routes;

import static io.javalin.apibuilder.ApiBuilder.*;

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

public class Routes {
    
    public Routes(){
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
    }

    private void homePageRoute() {
        get(HomeController.getPath(), HomeController::renderHomePage);
    }

    private void resumePageRoutes() {
        get(ResumeController.getPath(), ResumeController::renderResumePage);
    }

    private void jobPageRoute() {
        get(JobsController.getPath(), JobsController::renderjobsPage);
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
        get(RegisterController.getPath(), RegisterController::renderRegisterPage);
    }
}
