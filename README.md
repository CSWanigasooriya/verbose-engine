# Verbose Engine

## Commit Message Format
Each commit message consists of a header, an optional body, and an optional footer. The header has a specific format that includes a type, an optional scope, and a subject:

```
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```


## Types
- feat: A new feature for the user.
- fix: A bug fix for the user.
- docs: Documentation updates.
- style: Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc).
- refactor: A code change that neither fixes a bug nor adds a feature.
- perf: A code change that improves performance.
- test: Adding missing tests or correcting existing tests.
- chore: Changes to the build process or auxiliary tools and libraries such as documentation generation.
- build: Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm).
- ci: Changes to our CI configuration files and scripts (example scopes: Travis, Circle, BrowserStack, SauceLabs).
- revert: Reverts a previous commit.

## Scopes
The scope can be anything specifying the place of the commit change. For a Spring Boot project, common scopes might include:

- app: General application-level changes.
- config: Configuration-related changes.
- entity: Entity-related changes.
- controller: Controller-related changes.
- service: Service-related changes.
- repository: Repository-related changes.
- security: Security-related changes.
- util: Utility classes or functions.

## Subject
Use the imperative, present tense: “change” not “changed” nor “changes”.
Do not capitalize the first letter.
Do not end the subject line with a period.

## Body
Use the body to explain the what and why of the commit, not the how.

## Footer
The footer should contain any information about Breaking Changes and is also the place to reference GitHub issues that this commit closes.

## Examples
### Example 1: Adding a New Feature
```
feat(controller): add user login endpoint

Implemented the user login endpoint using JWT authentication.
This allows users to securely log into the application.
```

### Example 2: Fixing a Bug
```
fix(service): resolve null pointer exception in user service

Fixed a bug where a null pointer exception was thrown in the user service
when the user details were not found in the database.
```
### Example 3: Updating Documentation
```
docs: update readme with setup instructions

Added detailed setup instructions to the README file to help new developers
get started with the project.
```
### Example 4: Refactoring Code
```
refactor(entity): optimize user entity structure

Refactored the User entity to improve performance and maintainability.
Removed redundant fields and updated related service methods.
```
### Example 5: Adding Tests
```
test(controller): add unit tests for user controller

Added unit tests for the user controller to ensure that all endpoints are
working as expected and to improve test coverage.
```
