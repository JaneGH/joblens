package com.itclimb.joblens.ui.jobs

import com.itclimb.joblens.domain.model.ApplicationStatus
import com.itclimb.joblens.domain.model.Job
import com.itclimb.joblens.domain.model.Seniority
import com.itclimb.joblens.domain.model.Skill
import com.itclimb.joblens.domain.model.WorkType

fun fakeJobs(): List<Job> = listOf(
    Job(
        id = 1,
        title = "Senior Android Engineer",
        company = "Example Inc.",
        location = "Remote",
        workType = WorkType.REMOTE,
        seniority = Seniority.SENIOR,
        experienceText = "5+ years",
        originalDescription = "Senior Android Engineer. Kotlin, Jetpack Compose, and Coroutines.",
        requiredSkills = listOf(
            Skill(name = "Kotlin"),
            Skill(name = "Jetpack Compose"),
        ),
        preferredSkills = listOf(Skill(name = "GraphQL")),
        status = ApplicationStatus.APPLIED,
    ),
    Job(
        id = 2,
        originalDescription = "Android developer. Title and company were not extracted.",
        status = ApplicationStatus.SAVED,
    ),
    Job(
        id = 3,
        title = "Android Engineer",
        company = "Northwind",
        location = "Berlin",
        workType = WorkType.HYBRID,
        seniority = Seniority.MID,
        originalDescription = "Android Engineer. Kotlin and testing.",
        requiredSkills = listOf(Skill(name = "Kotlin")),
        status = ApplicationStatus.RECRUITER_SCREEN,
    ),
)
