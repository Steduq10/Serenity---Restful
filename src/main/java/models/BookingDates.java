package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import utils.JsonConverter;
@JsonPropertyOrder({
        "checkin",
        "checkout"
})
public class BookingDates extends JsonConverter {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("checkin")
    private String checkin;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("checkout")
    private String checkout;


    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
