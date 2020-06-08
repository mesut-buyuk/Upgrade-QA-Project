package com.upgrade.POJO;

public class LoginPOJO {

    public String firstName;
    public String userId;
    public String userUuid;
    public Object loanApplications;
    public LoansInReviewPOJO loansInReviewPOJO;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public Object getLoanApplications() {
        return loanApplications;
    }

    public void setLoanApplications(Object loanApplications) {
        this.loanApplications = loanApplications;
    }

    public LoansInReviewPOJO getLoansInReviewPOJO() {
        return loansInReviewPOJO;
    }

    public void setLoansInReviewPOJO(LoansInReviewPOJO loansInReviewPOJO) {
        this.loansInReviewPOJO = loansInReviewPOJO;
    }

}
