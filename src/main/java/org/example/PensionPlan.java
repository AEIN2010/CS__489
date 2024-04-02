package org.example;

import java.time.LocalDate;

public class PensionPlan {
    private String planReferenceNumber;

    private double monthlyContribution;

    // Constructor
    public PensionPlan(String planReferenceNumber, double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;

        this.monthlyContribution = monthlyContribution;
    }

    // Getters and Setters
    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(String planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public double getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }
}
