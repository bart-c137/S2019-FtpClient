# Development Strategy
This document captures the rules developers must follow while working in this repository.  Intentionally, not every aspect of software development is covered in this document and the ares which are covered are ones where the rules can clearly be enforced.

## Git Strategy
Source code management is a vital component of software development.  A disorganized and chaotic repository will ultimately lead to a number of bugs being introduced, reintroducing old bugs, wasted effort by the development team, and ultimately a low quality product.  Even though this document is a set of guidelines, the Git strategy is more of a rule.  I believe proper source management is so important that anyone not following the steps below will not have the pull request approved.

This project follows the *Feature Branch Workflow* as described in [Atlassian Bitbucket](https://www.atlassian.com/git/tutorials/comparing-workflows/feature-branch-workflow), I don't know where the original idea came from but Bitbucket has a very nice overview of it.  The general idea is the ``master`` branch ***always*** contains the latest production code and is used for deployment.  ***All*** work done in separate branches pulled off of ``master`` and then merged back in with a pull request.  This flow is shown below.

![Feature Branch Workflow](./misc/git-flow.svg)

The basic idea is anytime you work on something new, you create a new branch first, you ***never*** work in ``master``.  As an example, assume you are working on a bug, here is how the flow would work.

1.  Create a new branch (BR) off of ``master`` and name it ``bug-1``.  The bug number should match the bug ID from the scrum tool.
2.  Do your work in this new ``bug-1`` branch, making commits (C) as you normally would.
3.  When your bug fix is complete, create a pull request (PR).
4.  Someone will do a code review and accept the PR.
5.  Merge (M) the PR into the ``master`` branch.

The merge can only happen after the PR has been approved.  The ``bug-1`` branch will never be used again and can safely be deleted if you want.  This process is performed by all team members working on this project.

What happens if someone else creates a new branch off of ``master`` while I'm working on my bug fix?  How will they receive my changes if I merge first or how will I receive their changes if they merge first?  There are two possibilities here: either pull the ``master`` branch into your local to make sure your up to date, or when you do the merge any conflicts will be identified and have to be fixed.

### Branch Naming Conventions
The project uses [Taiga](https://taiga.io/) to manage sprints and can be found [here](https://tree.taiga.io/project/bart-c137-s2019-ftpclient/timeline) if you're interested.  Taiga uses stories, tasks, and issues to manage work.  Issues are further broken down into bugs, questions, and enhancements.  All of these are work items and are identified by a simple incrementing number.  When creating new branches, name them as follows

- ``story-#`` for stories where ``#`` is the story ID.
- ``task-#`` for tasks where ``#`` is the task ID.
- ``bug-#`` for bugs where ``#`` is the bug ID.
- ``enhancement-#`` for enhancements where ``#`` is the enhancement ID.

You should only use the ``story`` branch if you believe you can complete the entire story during the sprint.  Otherwise you should use one of the other branches.

## Coding Standards
Coding standards may seem trivial on small teams, but they very important.  Readable and understandable code helps not only the developer currently working on the file, but also other developers who need to use that code, wether that be now or in the future.  This repository follows the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) for the Java language.
