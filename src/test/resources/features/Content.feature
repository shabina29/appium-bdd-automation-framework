Feature: Content Screen Validation in API Demos App

  Background:
    Given the app is launched successfully

  @smoke @navigation
  Scenario: Verify user can navigate to Content screen
    When user taps on "Content"
    Then Content screen should be displayed

  @ui
  Scenario: Verify all options are visible in Content screen
    When user taps on "Content"
    Then the following options should be visible:
      | Assets     |
      | Clipboard  |
      | Provider   |
      | Resources  |

  @functional
  Scenario Outline: Verify user can open each Content option
    When user taps on "Content"
    And user taps on "<menu>"
    Then "<menu>" screen should be displayed

    Examples:
      | menu      |
      | Assets    |
      | Clipboard |
      | Provider  |
      | Resources |

  @navigation
  Scenario: Verify back navigation from Content screen
    When user taps on "Content"
    And user presses back button
    Then user should be on home screen

  @scroll
  Scenario: Verify Content screen is scrollable
    When user taps on "Content"
    Then user should be able to scroll the screen

  @stability
  Scenario: Verify app does not crash on multiple taps
    When user taps on "Content" multiple times
    Then app should not crash

  @accessibility
  Scenario: Verify accessibility id for Content element
    Then "Content" element should have accessibility id

  @negative
  Scenario: Verify handling of invalid element
    When user tries to find invalid element
    Then proper error should be displayed

  @performance
  Scenario: Verify Content screen load time
    When user taps on "Content"
    Then screen should load within acceptable time