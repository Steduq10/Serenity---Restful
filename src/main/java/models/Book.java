package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import utils.JsonConverter;

@JsonPropertyOrder({
                "firstname",
                "lastname",
                "totalprice",
                "depositpaid",
                "bookingdates",
                "additionalneeds"
        })

public class Book extends JsonConverter {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("firstname")
    private String firstname;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("lastname")
    private String lastname;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("totalprice")
    private Integer totalprice;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("depositpaid")
    private Boolean depositpaid;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("bookingdates")
    private BookingDates bookingdates;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("additionalneeds")
    private String additionalneeds;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
