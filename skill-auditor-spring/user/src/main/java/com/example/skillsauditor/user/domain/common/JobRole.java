package com.example.skillsauditor.user.domain.common;

public enum JobRole{

    MANAGER("Manager"),
    STAFF("Staff");

    private final String jobRole;

    JobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getJobRole() {
        return jobRole;
    }

}
