package starter.stepdef.User.HoteRating;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.User.HotelRating.CreateHotelRatingPage;

public class CreateHotelRatingSteps {
    @Steps
    CreateHotelRatingPage hotelRating;

    @Given("user set valid endpoint for login user")
    public void userSetValidEndpointForLoginUser() {
        hotelRating.setEndpointLoginUser();
    }

    @When("user send request to auth user")
    public void userSendRequestToAuthUser() {
        hotelRating.sendReqToAuthUser();
    }

    @When("user set endpoint for create a new hotel rating")
    public void userSetEndpointForCreateANewHotelRating() {
        hotelRating.setEndpointNewRatingHotel();
    }

    @And("user send request for create a new hotel rating")
    public void userSendRequestForCreateANewHotelRating() {
        hotelRating.sendReqForCreateNewHotelRating();
    }

    @Then("user success create new hotel rating and see status code {int}")
    public void userSuccessCreateNewHotelRatingAndSeeStatusCode(int arg0) {
        hotelRating.validateStatusCode();
    }

    @And("i validate data hotel rating")
    public void iValidateDataHotelRating() {
        hotelRating.validateDataHotelRating();
    }
}
