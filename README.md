# Mariam-Ashraf

# Instabug Challenge


# First Part:
## High Level Scenarios for LinkedIn
	
| High Level Scenario       | Priority          | 
| ------------- |:-------------:|
|Validate that registration function is working with required new valid email or mobile number, password with 6 or more characters, first name, last name, location, and educational information. Besides accepting user agreement, privacy policy, and cookie policy. Next, the email or mobile number is verified by entering 2-FA code| High | 
|Validate that password at registration is in encrypted form when entered, in addition to clicking on eye mask icon, the entered password should be visible in a readable format. In addition, copying password shouldn't be allowed |High|   
|Validate that registration should fail with an already existing email or mobile number and an informative error message should appear |Medium|	
|Validate that registration should fail with a password less than 6 characters and an informative error message should appear|Medium|
|Validate login functionality with a required registered email and valid password|High|
|Validate that login functionality is working with a google account and apple id account|High|
|Validate that login functionality should fail with a valid email id and incorrect password, and an informative error message should appear|Medium|
|Validate that forget password function is working with a valid email id and check if a 2-FA code to change the password is sent to that email id|High|
|Validate that a logged in user can set profile picture uploaded from mobile photos or take it from the mobile camera|Medium|
|Validate that a logged in user can set cover photo from mobile photos or through mobile camera|Medium|
|Validate that a logged in user can add/edit his account information includes [About, Contact Info, Featured, Work Experience, Education, Skills, Courses, Projects, and Certifications]|High|
|Validate that a logged in user can add a new post by choosing ‘Who can see this post?’ and by adding one or more of talk, photos, videos, documents, events, or a poll|High|
|Validate that a logged in user can search for a connections or jobs with at least one character is written at the search field and clear search history|Medium|
|Validate that a logged in user can send request to a connection or follow a connection|High|
|Validate that a logged in user can accept or decline received connection requests|Medium|
|Validate that a logged in user can remove an existing connection|Medium|
|Validate that a logged in user can view the added connections profiles|Medium|
|Validate that a logged in user can send/receive messages in his inbox, check unread messages are highlighted, and verify count of unread messages|High|
|Validate that a logged in user can receive a different notifications when (connection requests gets approved, tagging by someone on posts or comments, getting comments or reactions on posts) on LinkedIn ‘Notifications’ icon. In addition to Validating receiving notifications on email or phone notification list based on the chosen settings|High|
|Validate performance of the app on different internet networks 4G and Wi-Fi|High|
|Validate that an error message appears at the app when the internet connection is lost|High|
|Validate that the mobile app display is adaptable to the device screen and also validate all menus on the app|High|	
|Validate that the app still operates as designed when a message or notification pop-up from another app or when there is an incoming call or SMS|High|
|Validate that a logged in user can log out and be redirected to the welcome page|High|
|Validate how the app function under different battery levels|Low|
|Validate the font size and style of the app are compatible and readable to the users|Low|
|Validate mobile gestures scrolling, swiping, portrait, and landscape modes|Low|


# Second Part
## Defects for LinkedIn Android mobile app
### 1. Bug_01
- #### Title : Search Page _ Wrong search results when searching by entering special characters in the search field
- #### ReproducibleSteps :
   - ##### Insatll the app
   - ##### Log in with a valid account
   - ##### Click on the search field at Home page
   - ##### Type special characters at the search field '@@#%&*%#$'
   - ##### Check the result
- #### Expected Result: No result message should be appeared
- #### Actual Result: Wrong search results that doesn't related to special characters
- #### Attachments: Bugs Attachments/SearchResult.jpeg, ugs Attachments/SearchResult1.jpeg
- #### AffectedDevices: Android (Oppo A9)
- #### Network: Wifi
- #### Severity: Low
- #### Priority: Low

### 2. Bug_02
- #### Title : Cross-Language Arabic Localization
- #### ReproducibleSteps :
   - ##### Insatll the app
    - ##### Change the language of mobile device to Arabic
    - ##### Open the app
   - ##### Log in with a valid account
   - ##### Check the text of UI [Home, Profile, My Network, Invitations pages]
- #### Expected Result: All text should be in Arabic
- #### Actual Result: Some text appears in English 
- #### Attachments: Bugs Attachments/Arabic Language.jpeg, Bugs Attachments/Arabic Language1.jpeg, Bugs Attachments/Arabic Language2.jpeg, Bugs Attachments/Arabic Language3.jpeg
- #### AffectedDevices: Android (Oppo A9)
- #### Network: Wifi
- #### Severity: Low
- #### Priority: Medium

### 3. Bug_03
- #### Title : User Agreement _ Wrong Effective Date in Arabic Language
- #### ReproducibleSteps :
   - ##### Insatll the app
    - ##### Change the language of mobile device to Arabic
    - ##### Open the app
   - ##### Log in with a valid account
   - ##### Click on user picture icon
   - ##### Click on Settings
   - ##### Scroll Down
   - ##### Click on User Agreement
   - ##### Check the effective date of user agreement 
- #### Expected Result: ساربة بتاريخ 1 فبراير،٢٠٢٢
- #### Actual Result: ساربة بتاريخ 1فبراير،2022 ٢٠٢٠
- #### Attachments: Bugs Attachments/User Agreement in Arabic.jpeg, Bugs Attachments/User Agreement in English.jpeg
- #### AffectedDevices: Android (Oppo A9)
- #### Network: Wifi
- #### Severity: Low
- #### Priority: Low

### 4. Bug_04
- #### Title : My Jobs _ the number of My Jobs in the mobile app is different from the web app
- #### ReproducibleSteps :
   - ##### Insatll the app
    - ##### Open the app
   - ##### Log in with a valid account
   - ##### Click on user picture icon
   - ##### Click on View Profile
   - ##### Click on Show all Resurces
   - ##### Click on My Items
   - ##### Check number of My Jobs
   - ##### Open LinkedIn from web with the same account
   - Click on My Items
   - Check number of My Jobs

- #### Expected Result: Number of my jobs should be the same at mobile and web
- #### Actual Result: Number of my jobs at mobile and web is different
- #### Attachments: Bugs Attachments/Number of jobs mobile.jpeg, Bugs Attachments/Number of jobs web.jpeg
- #### AffectedDevices: Android (Oppo A9)
- #### Network: Wifi
- #### Severity: Low
- #### Priority: Low


### 5. Bug_05
- #### Title : Messaging _ Unable to see calendar in dark mood at Schedule meeting for later 
- #### ReproducibleSteps :
   - ##### Insatll the app
    - ##### Open the app
   - ##### Log in with a valid account
   - ##### Click on user picture icon
   - ##### Click on Settings
   - ##### Click on Account Preferences
   - ##### Select Dark Mood at Display
   - ##### Go Back
   - ##### Click on Messages icon
   - ##### Choose chat of a connection 'friend'
   - ##### Click on Meeting icon at the top of screen
   - ##### Click on Schedule meeting for later
   - ##### Click on start date
   - ##### Check the calendar

- #### Expected Result: calendar should appear at dark mode and all numbers should visible
- #### Actual Result: calendar appears at light mode and numbers are invisible
- #### Attachments: Bugs Attachments/CalendarDark.jpeg, Bugs Attachments/CalendarLight.jpeg
- #### AffectedDevices: Android (Oppo A9)
- #### Network: Wifi
- #### Severity: Low
- #### Priority: Low