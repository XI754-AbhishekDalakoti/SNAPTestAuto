var BasePage = function(){

    this.navigateToURL = function(){
        var OR = require('../json/OR.json');
        browser.get(OR.url);

    };
    this.getPageTitle = function(){
        return browser.getTitle();
    }
    this.getCurrentURL = function(){
        return browser.driver.getCurrentUrl();
    }
};
module.exports = new BasePage();