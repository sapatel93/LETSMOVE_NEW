package com.example.sachinpatel.letsmove;

public class UserBean2 {
    String bid_id;
    String post_id;
    String user_bidder_id;
    String bidder_name;
    String bidder_email;
    String bidder_mobile;
    String bid_amount;
    String bid_description;
    String average_Rating;

    String message_from_id;
    String message_to_id;
    String message;

    public String getMessage_to_id() {
        return message_to_id;
    }

    public void setMessage_to_id(String message_to_id) {
        this.message_to_id = message_to_id;
    }

    public String getMessage_from_id() {
        return message_from_id;
    }

    public void setMessage_from_id(String message_from_id) {
        this.message_from_id = message_from_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //data for my_bids detail
    String myBid_post_name, myBid_post_type, myBid_post_cost, myBid_bid_amount, myBid_bid_desc;

    public String getBid_id() {
        return bid_id;
    }

    public String getMyBid_post_name() {
        return myBid_post_name;
    }

    public void setMyBid_post_name(String myBid_post_name) {
        this.myBid_post_name = myBid_post_name;
    }

    public String getMyBid_post_type() {
        return myBid_post_type;
    }

    public void setMyBid_post_type(String myBid_post_type) {
        this.myBid_post_type = myBid_post_type;
    }

    public String getMyBid_post_cost() {
        return myBid_post_cost;
    }

    public void setMyBid_post_cost(String myBid_post_cost) {
        this.myBid_post_cost = myBid_post_cost;
    }

    public String getMyBid_bid_amount() {
        return myBid_bid_amount;
    }

    public void setMyBid_bid_amount(String myBid_bid_amount) {
        this.myBid_bid_amount = myBid_bid_amount;
    }

    public String getMyBid_bid_desc() {
        return myBid_bid_desc;
    }

    public void setMyBid_bid_desc(String myBid_bid_desc) {
        this.myBid_bid_desc = myBid_bid_desc;
    }

    public void setBid_id(String bid_id) {
        this.bid_id = bid_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getUser_bidder_id() {
        return user_bidder_id;
    }

    public void setUser_bidder_id(String user_bidder_id) {
        this.user_bidder_id = user_bidder_id;
    }

    public String getBidder_name() {
        return bidder_name;
    }

    public void setBidder_name(String bidder_name) {
        this.bidder_name = bidder_name;
    }

    public String getBidder_mobile() {
        return bidder_mobile;
    }

    public void setBidder_mobile(String bidder_mobile) {
        this.bidder_mobile = bidder_mobile;
    }

    public String getBidder_email() {
        return bidder_email;
    }

    public void setBidder_email(String bidder_email) {
        this.bidder_email = bidder_email;
    }

    public String getBid_description() {
        return bid_description;
    }

    public void setBid_description(String bid_description) {
        this.bid_description = bid_description;
    }

    public String getBid_amount() {
        return bid_amount;
    }

    public void setBid_amount(String bid_amount) {
        this.bid_amount = bid_amount;
    }

    public String getAverage_Rating() { return average_Rating; }

    public void setAverage_Rating(String average_Rating) {
        this.average_Rating = average_Rating;
    }

}
