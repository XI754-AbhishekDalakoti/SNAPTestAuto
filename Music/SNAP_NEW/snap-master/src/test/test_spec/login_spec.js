var baseObject = require('../pages/BasePage.js');
var loginObject = require('../pages/LoginPage.js');
var OR = require('../json/OR.json');
var width = 800;
var height = 600;


describe('Verify validity of URL', function() {
    it('should check if the url redirected the user to Snap Login page', function() {
        browser.waitForAngularEnabled(false);
        browser.ignoreSynchronisation = true;
        baseObject.navigateToURL();
        var title = baseObject.getPageTitle();
        expect(title).toBe(OR.locators.data.loginpage_title);
    });
});

describe('Verify login functionality with valid credentials', function() {
        beforeEach(function(){
          browser.waitForAngularEnabled(false);
          browser.ignoreSynchronisation = true;
          browser.driver.manage().window().setSize(width, height);

        });
        it('should enter username and password in Login Page', function() {
            baseObject.navigateToURL();
            var title = baseObject.getPageTitle();
            expect(title).toBe(OR.locators.data.loginpage_title);
            loginObject.enterDetails();
        });
       it('should verify and enter details for Slack Page',function(){
             browser.driver.sleep(3000);
            var actualURL = baseObject.getCurrentURL();
           expect(actualURL).toEqual(OR.locators.data.slackpage_url);
          loginObject.enterSlackDetails();
        });
       it('should enter details on organisational login page',function(){
            var actualTitle = baseObject.getPageTitle();
           expect(actualTitle).toEqual(OR.locators.data.org_loginpage_title);
          loginObject.enterOrganizationDetails();
        });
        it('should verify SNAP home page',function(){
         browser.driver.sleep(7000);
          var actualTitle = baseObject.getPageTitle();
           browser.driver.sleep(3000);
           expect(actualTitle).toEqual(OR.locators.data.homepage_title);
            loginObject.logout();
        });

});

describe('Verify the login functionality with empty username',function(){
        beforeEach(function(){
            browser.waitForAngularEnabled(false);
            browser.ignoreSynchronization = true;
            baseObject.navigateToURL();
            browser.driver.manage().window().maximize();
        });
        it('should not login the user and popup should be displayed', function() {
            loginObject.enterEmptyUsername();
        });
});

describe('Verify the login functionality with invalid username',function(){
        beforeEach(function(){
            browser.waitForAngularEnabled(false);
            browser.ignoreSynchronization = true;
            baseObject.navigateToURL();
            browser.driver.manage().window().setSize(width, height);
        });
        it('should not login the user and error message should be displayed', function() {
            var actual_error = loginObject.enterInvalidUsername();
            expect(actual_error.getText()).toEqual(OR.locators.data.error_msg);
        });
});

describe('Verify the login functionality with empty password',function(){
        beforeEach(function(){
            browser.waitForAngularEnabled(false);
            browser.ignoreSynchronization = true;
            baseObject.navigateToURL();
            browser.driver.manage().window().setSize(width, height);
        });
        it('should not login the user and popup should be displayed', function() {
            loginObject.enterEmptyPassword();
        });
});

describe('Verify the login functionality with invalid password',function(){
        beforeEach(function(){
            browser.waitForAngularEnabled(false);
            browser.ignoreSynchronization = true;
            baseObject.navigateToURL();
           browser.driver.manage().window().setSize(width, height);
        });
        it('should not login the user and error message should be displayed', function() {
            var actual_error = loginObject.enterInvalidPassword();
            expect(actual_error.getText()).toEqual(OR.locators.data.error_msg);
        });
});

describe('Verify the login functionality with invalid credentials',function(){
        beforeEach(function(){
            browser.waitForAngularEnabled(false);
            browser.ignoreSynchronization = true;
            baseObject.navigateToURL();
           browser.driver.manage().window().setSize(width, height);
        });
        it('should not login the user and error message should be displayed', function() {
            var actual_error = loginObject.enterInvalidCredentials();
            expect(actual_error.getText()).toEqual(OR.locators.data.error_msg);
        });
});

describe('Verify the login functionality with empty credentials',function(){
        beforeEach(function(){
            browser.waitForAngularEnabled(false);
            browser.ignoreSynchronization = true;
            baseObject.navigateToURL();
            browser.driver.manage().window().setSize(width, height);
        });
        it('should not login the user and error message should be displayed', function() {
            loginObject.enterEmptyCredentials();

        });
});

describe('Verify user navigation on Contact the Helpdesk link',function(){
        beforeEach(function(){
            browser.waitForAngularEnabled(false);
            browser.ignoreSynchronization = true;
            baseObject.navigateToURL();
            browser.driver.manage().window().setSize(width, height);
        });
        it('should redirect user to helpdesk page', function() {
            loginObject.contactHelpdesk();
        });
});
