# JobLens

> AI-powered job intelligence for Android developers.

## Problem

Android developers searching for jobs often review and compare many job descriptions manually.

As the number of interesting positions grows, it becomes difficult to understand:

- which jobs are the strongest match;
- which required skills are already covered;
- which important skills are missing;
- which technologies appear most frequently across target jobs;
- what to learn next based on actual market demand;
- what to prepare for a specific interview.

Job platforms primarily help users discover jobs. JobLens focuses on helping developers understand and compare the jobs they are already interested in.

## Solution

JobLens is an Android application that transforms unstructured job descriptions into structured job requirements using AI.

It allows developers to save and organize jobs, compare requirements against their developer profile, identify skill gaps, and eventually analyze trends across their target job market.

JobLens follows an important engineering principle:

> AI interprets unstructured information. Deterministic application logic handles calculations and important business decisions whenever possible.

For example, AI can extract skills from a job description, but JobLens calculates match results and market statistics from structured local data.

## Core Flow

```text
Job Description
       ↓
AI Extraction
       ↓
Structured Job Analysis
       ↓
User Review / Correction
       ↓
Save Locally
       ↓
Compare With Developer Profile
       ↓
Matched / Missing Skills
```

AI-generated information is treated as a proposal until the user reviews and saves it.

## MVP

The user can:

1. Create a developer profile with their Android skills.
2. Paste a job description.
3. Analyze the description using AI.
4. Review and edit the extracted information.
5. Save the confirmed job locally.
6. View saved jobs.
7. Open job details.
8. Track basic application status.
9. Compare job requirements against the developer profile.
10. See matched, partial, and missing skills.

The original job description must be preserved.

Missing information must remain missing rather than being invented by AI.

## AI Responsibilities

AI may be used to:

- extract structured information from job descriptions;
- identify required and preferred skills;
- normalize ambiguous job terminology where appropriate;
- generate interview preparation in later versions.

AI should not be responsible for:

- calculating arbitrary match percentages;
- calculating market statistics;
- deciding what data is trusted without user review;
- inventing missing salary, experience, location, or requirements.

## Local Data

Confirmed job information is stored locally and becomes the application's source of truth.

Conceptually:

```text
Raw Job Description
        ↓
AI Proposal
        ↓
User Review
        ↓
Confirmed Structured Data
        ↓
Local Storage
        ↓
Matching / Analytics
```

AI failure must never corrupt previously saved data.

## Later

After the core MVP works reliably, JobLens may add:

- job market analytics;
- personal learning priorities based on saved jobs;
- interview preparation;
- mock interviews;
- Android Share Sheet integration;
- adaptive layouts for tablets and foldables;
- on-device AI with Gemini Nano / ML Kit GenAI;
- cloud/on-device AI fallback;
- performance measurement and optimization.

These features should be added incrementally rather than designed into the MVP prematurely.

## Non-Goals for MVP

JobLens will not initially support:

- automatic job applications;
- large-scale job scraping;
- LinkedIn automation;
- recruiter messaging automation;
- resume generation;
- cover-letter generation;
- automatic hiring decisions;
- complex account or cloud synchronization.

## Engineering Principles

JobLens should:

- remain a single-module Android application until modularization solves a real problem;
- use Kotlin and Jetpack Compose;
- follow unidirectional data flow;
- separate domain models from persistence models;
- keep business logic outside Composables;
- prefer deterministic and testable logic where AI is unnecessary;
- treat AI output as potentially incorrect;
- preserve original source information;
- avoid premature abstractions;
- avoid unnecessary dependencies;
- remain useful when cloud AI features are unavailable.

## Product Principle

When considering a new feature, abstraction, dependency, or AI call, ask:

> Does this make JobLens more useful, reliable, testable, or demonstrate a meaningful engineering decision?

If not, do not add it yet.