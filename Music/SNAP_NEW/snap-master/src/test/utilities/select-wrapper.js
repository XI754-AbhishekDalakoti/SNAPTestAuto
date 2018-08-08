var SelectWrapper = function(selector) {
    this.webElement = element(selector);
};
SelectWrapper.prototype.getOptions = function() {
    return this.webElement.all(by.tagName('option'));
};